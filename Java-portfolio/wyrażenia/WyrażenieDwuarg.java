package wyrażenia;

abstract class WyrażenieDwuarg extends Wyrażenie{

    protected Wyrażenie arg1;
    protected Wyrażenie arg2;

    public WyrażenieDwuarg(Wyrażenie arg1, Wyrażenie arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "WyrażenieDwuarg{" +
                "arg1=" + arg1 +
                ", arg2=" + arg2 +
                '}';
    }


}
