namespace java com.nobodyhub.learn.thrift.spring.service

enum TOperation {
    ADD = 1,
    SUBTRACT = 2,
    MULTIPLY = 3,
    DIVIDE = 4
}

exception TDivisionByZeroException {
}

service TCalculatiorService {
    i32 calculator(
        1: i32 num1,
        2: i32 num2,
        3: TOperation op
    ) throws (
        1: TDivisionByZeroException divisionException
    )
}