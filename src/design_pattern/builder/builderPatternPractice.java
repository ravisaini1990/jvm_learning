package design_pattern.builder;

public class builderPatternPractice {

    public static void main(String[] args) {
        Analytics analytics = Analytics.Builder.getBuilder()
                .setEventName("Button Clicked")
                .setEventType("Clicked")
                .setScreenName("Home")
                .build();
        System.out.println(analytics);
    }
}

final class Analytics {
    private final String eventName;
    private final String eventType;
    private final String screenName;

    Analytics(Builder analyticsBuilder) {
        this.eventName = analyticsBuilder.eventName;
        this.eventType = analyticsBuilder.eventType;
        this.screenName = analyticsBuilder.screenName;
    }

    @Override
    public String toString() {
        return "Analytics{" +
                "eventName='" + eventName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", screenName='" + screenName + '\'' +
                '}';


    }

    //static builder
    static class Builder {
        private String eventName;
        private String eventType;
        private String screenName;

        private Builder() {
        }

        public static Builder getBuilder() {
            return new Builder();
        }

        public Builder setEventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder setScreenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public Builder setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Analytics build() {
            return new Analytics(this);
        }
    }
}
