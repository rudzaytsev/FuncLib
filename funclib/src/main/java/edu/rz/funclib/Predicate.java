package edu.rz.funclib;

/**
 * Created by rudolph on 07.09.15.
 */
public abstract class Predicate<ArgType> extends Function<ArgType, Boolean> {

    public Predicate(){
        //does nothing
    }

    public Predicate(ArgType argument){
        super(argument);
    }

    public Predicate not(){
        final Predicate<ArgType> basePredicate = this;
        return new Predicate<ArgType>() {
            @Override
            public Boolean invoke() {
                basePredicate.argument = this.argument;
                return !basePredicate.invoke();
            }
        };
    }

    public Predicate and(final Predicate<ArgType> otherPred){
        final Predicate<ArgType> basePredicate = this;
        return new Predicate<ArgType>() {
            @Override
            public Boolean invoke() {
                basePredicate.argument = this.argument;
                otherPred.argument = this.argument;
                return basePredicate.invoke() && otherPred.invoke();
            }
        };
    }

    public Predicate or(final Predicate<ArgType> otherPred){
        final Predicate<ArgType> basePredicate = this;
        return new Predicate<ArgType>() {
            @Override
            public Boolean invoke() {
                basePredicate.argument = this.argument;
                otherPred.argument = this.argument;
                return basePredicate.invoke() || otherPred.invoke();
            }
        };
    }

}
