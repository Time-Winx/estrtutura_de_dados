#### Implementação 3.a 
    public String parentheticRepresentation (Tree<E> T, Position<E> v) {

        String s = v.element().toString(); // ação principal de visita
        if (T.isInternal(v)) {
            Boolean firstTime = true;
            for (Position<E> w : T.children(v)) {
                if (firstTime) { // primeiro filho
                    s += "(\n"  + parentheticRepresentation(T,w);
                    firstTime = false;
                } 
                else { // filhos seguintes
                    s += "," + parentheticRepresentation(T, w);
                }
                s += ")";
            }
        }
        return s;
