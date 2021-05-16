package arthur.com.example.escola.Enums;

public enum BimestreEnum {
    BIMESTRE_1(1),
    BIMESTRE_2(2),
    BIMESTRE_3(3),
    BIMESTRE_4(4);

    private int codigo; //codigo do tipo enumerado

    BimestreEnum(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static BimestreEnum valor(int codigo) { //metodo que retorna um BimestreEnum a partir do codigo;

        for(BimestreEnum valor : BimestreEnum.values()) {//percorre todos os valores
            if(valor.getCodigo() == codigo) {
                return valor;
            }
        }
        throw new IllegalArgumentException("valor do Bimestre invalido!");
    }
}
