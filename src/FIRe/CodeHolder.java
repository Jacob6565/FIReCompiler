package FIRe;

import FIRe.Exceptions.CodeGenException;

public class CodeHolder {
    String name;
    String outputCode;
    StringBuilder sb;

    CodeHolder(){
        sb = new StringBuilder();
    }

    boolean emitNL(String code){
        sb.append(code + "\n");
        return true;
    }

    boolean emit(String code){
        sb.append(code);
        return true;
    }

}
