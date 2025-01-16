package design_pattern.decorator;

public class DecoratorPatternPractice {
    public static void main(String[] args) {
        ServiceComponent serviceComponent = new WheelAlignmentAddon(new BasicCarService());
        System.out.println("Service Cost : "+serviceComponent.getCost());

        ServiceComponent serviceComponentWithVacuumCleaning = new VacuumCleaningAddon(new WheelAlignmentAddon(new BasicCarService()));
        System.out.println("Service Cost Now : "+serviceComponentWithVacuumCleaning.getCost() +" and details "+ serviceComponentWithVacuumCleaning.serviceDetails());
    }
}


abstract class ServiceComponent {

   String serviceDetails() { return "Basic Servicing"; }

   abstract int getCost();
}

class BasicCarService extends ServiceComponent {

    final int BASIC_SERVICE_COST = 10;

    @Override
    int getCost() {
        return BASIC_SERVICE_COST;
    }
}

abstract class ServiceAddOnDecorator extends ServiceComponent  {

    @Override
    int getCost() {
        return 0;
    }
}

class VacuumCleaningAddon extends ServiceAddOnDecorator {
    final int VACUUM_ADDON_COST = 2;

    ServiceComponent serviceComponent;

    VacuumCleaningAddon(ServiceComponent serviceComponent) {
        this.serviceComponent = serviceComponent;
    }

    @Override
    int getCost() {
        return serviceComponent.getCost() + VACUUM_ADDON_COST;
    }
}

class WheelAlignmentAddon extends ServiceAddOnDecorator {
    final int ALIGNMENT_ADDON_COST = 4;

    ServiceComponent serviceComponent;

    WheelAlignmentAddon(ServiceComponent serviceComponent) {
        this.serviceComponent = serviceComponent;
    }

    @Override
    int getCost() {
        return serviceComponent.getCost() + ALIGNMENT_ADDON_COST;
    }
}

