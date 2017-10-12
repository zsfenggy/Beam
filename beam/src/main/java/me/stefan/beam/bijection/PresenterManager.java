package me.stefan.beam.bijection;


import java.util.HashMap;

public class PresenterManager {

    private static class SingletonHolder {
        private static final PresenterManager INSTANCE = new PresenterManager();
    }

    public static PresenterManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private HashMap<String, Presenter> idToPresenter = new HashMap<>();
    private int nextId;

    public <T extends Presenter> T create(Object view) {
        T presenter = PresenterBuilder.fromViewClass(view.getClass());
        if (presenter == null) return null;

        presenter.id = providePresenterId();
        idToPresenter.put(presenter.id, presenter);
        return presenter;
    }

    public <T extends Presenter> T get(String id) {
        return (T) idToPresenter.get(id);
    }

    public void destroy(String id) {
        idToPresenter.remove(id);
    }

    private String providePresenterId() {
        return nextId++ + "/" + System.nanoTime() + "/" + (int) (Math.random() * Integer.MAX_VALUE);
    }

}
