package de.heisluft.egm.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class ClosableHashSet<E> extends HashSet<E> {

	private static final long serialVersionUID = 1L;
	
	public static <E> ClosableHashSet<E> of(E[] initialObjects) {
		final ClosableHashSet<E> set = new ClosableHashSet<>();
		set.addAll(Arrays.asList(initialObjects));
		return set;
	}
	
	private boolean isClosed = false;
	
	@Override
	public boolean add(E e) {
		return !isClosed && super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		return !isClosed && super.addAll(c);
	}
	
	public boolean addAll(E... elements) {
		if (isClosed)
			return false;
		boolean error = false;
		for (final E e : elements)
			error = add(e);
		return !error;
	}
	
	@Override
	public void clear() {
		if (!isClosed)
			super.clear();
	}
	
	public ClosableHashSet<E> close() {
		isClosed = true;
		return this;
	}

	public void disposeElements() {
		if (isClosed)
			super.clear();
	}
	
	public void disposeElementsAndReopen() {
		if (isClosed) {
			isClosed = false;
			clear();
		}
	}
	
	public boolean isClosed() {
		return isClosed;
	}
	
	@Override
	public boolean remove(Object o) {
		return !isClosed && super.remove(o);
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		return !isClosed && super.removeAll(c);
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		return !isClosed && super.removeIf(filter);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return !isClosed && super.retainAll(c);
	}

}
