package FIRe;

import FIRe.Exceptions.CodeGenException;

abstract class CodeHolder {
    protected StringBuilder sb;


    CodeHolder(){
        sb = new StringBuilder();
    }

    abstract String getCode();

    public String indent(String code, int tabIndent){
        String indent = "";
        String lines[] = code.split("\n");
        String indentedCode = "";
        for (int i = 0; i < tabIndent; i++){
            indent += ("\t");
        }
        for (String line : lines) {
            indentedCode += indent + line + "\n";
        }
        return indentedCode;
    }

    // Emitter and indenter
    boolean emit(String code, int tabIndent) {
        String indentedCode = indent(code, tabIndent);
        return emit(indentedCode);
    }

    // Emitter and indenter
    boolean emitNL(String code, int tabIndent) {
        String indentedCode = indent(code, tabIndent);
        return emit(indentedCode + "\n");
    }

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
