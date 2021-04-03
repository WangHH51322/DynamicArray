package com.wong;

public class ArrayList<T> {
    /**
     * 元素的数量
     */
    private int size;
    /**
     * 所有元素
     */
    private T[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            elements = (T[]) new Object[DEFAULT_CAPACITY];
        } else {
            elements = (T[]) new Object[capacity];
        }

    }
    /**
     * 构造函数之间互相调用通过this
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    /**
     * 抛出异常
     * @param index
     */
    private void OutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index=" + index + ",Size=" + size);
    }
    /**
     * 判断传入的index是否超出范围
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            OutOfBounds(index);
        }
    }
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            OutOfBounds(index);
        }
    }

    /**
     * 保证有capacity的容量
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) {
            return;
        }
        //oldCapacity >> 1 表示 *0.5 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    /**
     * 获取元素的数量
     * @return
     */
    public int size() {
        return size;
    }
    /**
     * 清楚所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    /**
     * 添加元素到末尾
     * @param element
     */
    public void add(T element) {
        add(size,element);
    }
    /**
     * 添加元素到指定位置
     * @param index
     * @param element
     */
    public void add(int index,T element) {
        rangeCheckForAdd(index);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
        /**
         * 确保数组在添加一个元素之后依然有足够的容量
         */
        ensureCapacity(size);
    }
    /**
     * 删除index未知的元素
     * @param index
     * @return 原本index位置的元素
     */
    public T remove(int index) {
        rangeCheck(index);
        T old = elements[index];
        for (int i = index+1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size --;
        elements[size] = null;
        return old;
    }
    /**
     * 获取index位置处的元素
     * @param index
     * @return
     */
    public T get(int index) {
        rangeCheck(index);
        return elements[index];
    }
    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     */
    public T set(int index,T element) {
        rangeCheck(index);
        T old = elements[index];
        elements[index] = element;
        return old;
    }
    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 打印数组
     * @return
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
//            if (i != size -1) {
//                string.append(", ");
//            }
        }
        string.append("]");
        return string.toString();
    }
}
