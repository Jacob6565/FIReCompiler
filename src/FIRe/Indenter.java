package FIRe;

abstract public class Indenter {
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
}
