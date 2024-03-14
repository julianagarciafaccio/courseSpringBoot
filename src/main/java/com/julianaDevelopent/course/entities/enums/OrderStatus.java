package com.julianaDevelopent.course.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);
    private int code;

    private OrderStatus(int code){ // aqui um construtor para o enum
        this.code = code;
    }
    public int getCode(){ // metodo responsavel por acessar o codigo digitado
        return code;
    }

    public static OrderStatus valueOf(int code){
        // maneira de percorrer todos os possiveis valores do enum e verificar se o numero digitado corresponder ao valor q tem ai retorna qual o status do pedido
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("INVALID ORDERSTATUS CODE");
    }


}
