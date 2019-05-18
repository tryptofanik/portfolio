package wyrażenia;

abstract class WyrażenieJednoarg extends Wyrażenie{

    protected Wyrażenie arg;

    public WyrażenieJednoarg(Wyrażenie arg) {
        this.arg = arg;
    }


}
