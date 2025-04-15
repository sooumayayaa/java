interface EventHandler {
    void handleEvent();
}

class EventDemo {
    void registerEvent() {
        // Local Inner Class
        class LocalEventHandler implements EventHandler {
            @Override
            public void handleEvent() {
                System.out.println("Event handled by local inner class");
            }
        }
        EventHandler localHandler = new LocalEventHandler();
        localHandler.handleEvent();
    }

    public static void main(String[] args) {
        EventDemo eventDemo = new EventDemo();
        eventDemo.registerEvent();

        // Anonymous Inner Class
        @SuppressWarnings("Convert2Lambda")
        EventHandler anonymousHandler = new EventHandler() {
            @Override
            public void handleEvent() {
                System.out.println("Event handled by anonymous inner class");
            }
        };
        anonymousHandler.handleEvent();
    }
}
