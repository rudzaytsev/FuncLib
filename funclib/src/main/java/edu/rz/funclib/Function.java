package edu.rz.funclib;

/**
 * Created by rudolph on 07.09.15.
 */
public abstract class Function<ArgType, RetType> {

    protected ArgType argument;

    public Function(){
        //does nothing
    }

    public Function(ArgType argument){
        this.argument = argument;
    }

    public ArgType getArgument() {
        return argument;
    }

    public void setArgument(ArgType argument) {
        this.argument = argument;
    }

    public abstract RetType invoke();
}
