package equationprocessor;

@FunctionalInterface
public interface Operation {
    int apply(int a, int b);
}