
## Questao 12 da AC 02

```
	public String makeFirst(Position<E> p, PositionList<E> l) {
		l.addBefore(l.first(), l.remove(p));
		String s = "";
		for (E i: l) { s += ", " + i; }
		s = (s.length() == 0 ? s : s.substring(2));
		return "[" + s + "]";
	}
```
