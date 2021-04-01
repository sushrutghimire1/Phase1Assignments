package equationprocessor;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public enum AllowedOperation implements Operation {
    PLUS("+", 1) {
        public double apply(double a, double b) {
            return a+b;
        }
    },
    MINUS("-", 1) {
        public double apply(double a, double b) {
            return a-b;
        }
    },
    DIVIDE("/", 2) {
        public double apply(double a, double b) {
            return a/b;
        }
    },
    MULTIPLY("*", 2) {
        public double apply(double a, double b) {
            return a*b;
        }
    },
    POWER("^", 3) {
        public double apply(double a, double b) {
            return Math.pow(a,b);
        }
    };

    private final String value;
    private final int index;

    AllowedOperation(String operator, int precedence) {
        this.value = operator;
        this.index = precedence;
    }

    public static AllowedOperation toOperator(String operator) {
        return Stream.of(AllowedOperation.values())
                .filter(allowedOperation -> allowedOperation.value.equals(operator))
                .findFirst().orElseThrow(() -> new RuntimeException("invalid operator"));
    }

    public static boolean isAllowedOperation(Character operator) {
        AtomicBoolean isAllowedOperation= new AtomicBoolean(false);
         Stream.of(AllowedOperation.values()).forEach(allowedOperation -> {
             if(allowedOperation.value.equals(operator.toString())){
                 isAllowedOperation.set(true);
             }
         });
        return isAllowedOperation.get();
    }

    public int getPrecedence() {
        return index;
    }


}