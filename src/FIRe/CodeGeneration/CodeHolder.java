/*
The CodeHolder classes works as an element of the objective code. They contain methods to properly add code, and to
format the code correctly. The codeholders contains (holds) the code of the element temporarily while the codeholders
are getting filled during the codegeneration. When all code has been processed and translated the codeholders will be
assembled to print out one single string.
 */
package FIRe.CodeGeneration;


abstract class CodeHolder extends CG{
    protected StringBuilder sb;


    CodeHolder(){
        sb = new StringBuilder();
    }

    // Emitter and indenter
    boolean emit(String code, int tabIndent) {
        return emit(indent(code,tabIndent));
    }

    // Emitter and indenter
    boolean emitNL(String code, int tabIndent) {
        return emit(indent(code,tabIndent) + "\n");
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