package utility;

public class OperationConverter {

    public static OperationEnum stringToEnum(String input) {
        return switch (input) {
            case "add" -> OperationEnum.ADD;
            case "minus" -> OperationEnum.MINUS;
            case "multiply" -> OperationEnum.MULTIPLY;
            default -> OperationEnum.UNSUPPORTED;
        };
    }
}
