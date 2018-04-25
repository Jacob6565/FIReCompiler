package FIRe;

import FIRe.Exceptions.CodeGenException;

abstract class CodeHolder {
    protected StringBuilder sb;


    CodeHolder(){
        sb = new StringBuilder();
    }

    abstract String getCode();


    boolean emitNL(String code){
        sb.append(code + "\n");
        return true;
    }

    boolean emitNL(Double code){
        sb.append(code + "\n");
        return true;
    }

    boolean emit(String code){
        sb.append(code);
        return true;
    }

    boolean emit(Double code){
        sb.append(code);
        return true;
    }

}
