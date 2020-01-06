//package TafPocLatest;
//
//import cucumber.api.event.ConcurrentEventListener;
//import cucumber.api.event.EventHandler;
//import cucumber.api.event.EventPublisher;
//import cucumber.api.event.TestRunFinished;
//import cucumber.api.event.TestRunStarted;
//
//public class BaseClass implements ConcurrentEventListener {
//
//    @Override
//    public void setEventPublisher(EventPublisher eventPublisher) {
//        eventPublisher.registerHandlerFor(TestRunStarted.class, setup);
//        eventPublisher.registerHandlerFor(TestRunFinished.class, teardown);
//    }
//
//    private EventHandler<TestRunStarted> setup = event -> {
//        beforeAll();
//    };
//
//    private void beforeAll() {
//        System.out.println("in before all");
//    }
//
//    private EventHandler<TestRunFinished> teardown = event -> {
//        afterAll();
//    };
//
//    private void afterAll() {
//        System.out.println("in after all");
//    }
//}