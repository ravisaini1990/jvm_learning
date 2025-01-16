package design_pattern.factory;

public class FactoryPatternPractice {

    public static void main(String[] args) {
        ICreater amaronBatteryCreater = new AmaronBatteryCreater();
        IProduct amaronProduct = amaronBatteryCreater.createFactory();
        amaronProduct.productDetails();

        ICreater exideBatterCreater = new ExideBatteryCreater();
        IProduct exideProduct = exideBatterCreater.createFactory();
        exideProduct.productDetails();
    }
}

interface IProduct {
    void productDetails();
}

class AmaronBattery implements IProduct {

    @Override
    public void productDetails() {
        System.out.println("AmaronBatteryMaker is making batteries");
    }
}

class ExideBattery implements IProduct {

    @Override
    public void productDetails() {
        System.out.println("ExideBatteryMaker is making batteries");
    }
}

interface ICreater {
    IProduct createFactory();
}

class AmaronBatteryCreater implements ICreater {

    @Override
    public IProduct createFactory() {
        return new AmaronBattery();
    }


}

class ExideBatteryCreater implements ICreater {

    @Override
    public IProduct createFactory() {
        return  new ExideBattery();
    }
}