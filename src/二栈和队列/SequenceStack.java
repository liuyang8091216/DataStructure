package ��ջ�Ͷ���;

/**
 * ˳��ջ
 * =============
 * ������ת��Ϊʮ���ơ�
 * =============
 * @author ������
 *
 * 2017��2��16��
 */
public class SequenceStack {
    
    private int STACK_INIT_SIZE = 5;//ջ��ԭʼ��С
    private int INCREMENT =1;//ջ��������С
     
     
    private Object []Stack = null;
    private int base;
    private int top;
    private int stacksize;
    
    public static void main(String[] args) {
        SequenceStack sStack = new SequenceStack();
        sStack.initStack();
        sStack.pop();
        sStack.push(1);
        sStack.push(2);
        sStack.push(3);
        sStack.push(4);
        sStack.push(5);
        sStack.push(6);
        sStack.push(3);
        sStack.print();
         
        sStack.pop();
        sStack.pop();
        sStack.pop();
        sStack.pop();
        sStack.print();
         
        System.out.println("ȡջ��Ԫ�أ�"+sStack.getTop());
        sStack.print();
    }
    
     
    /**
     * ��ʼ��ջ
     * */
    void initStack()
    {
        Stack = new Object[STACK_INIT_SIZE];
        base=0;
        top=0;
        stacksize=0;
    }
     
    /**
     * ��ջ
     * */
    void push(Object o)
    {
        if(top-base>=STACK_INIT_SIZE)
        {
            System.out.println("����ջ");
            STACK_INIT_SIZE=STACK_INIT_SIZE+INCREMENT;
            Object []temp = new Object[STACK_INIT_SIZE];
            for(int i=0;i<stacksize;i++)
            {
                temp[i]=Stack[i];
            }
            Stack=null;
            Stack=temp;
        }
        Stack[stacksize] = o;
        stacksize++;
        top++;
    }
    /**
     * ��ջ
     * */
    Object pop()
    {
        Object o = null;
        if(top==base)
        {
            System.out.println("ջ��û��Ԫ�أ�����null");
        }else
        {
            o=Stack[--top];
            stacksize--;
        }
        return o;
    }
     
    /**
     * ȡջ��Ԫ��
     * */
    Object getTop()
    {
        Object o = null;
        if(top==base)
        {
            System.out.println("ջ��û��Ԫ�أ�����null");
        }else
        {
            o=Stack[top-1];
        }
        return o;
    }
     
    /**
     * ��ӡջ
     * */
    void print()
    {
        System.out.print("��ӡջ��");
        for(int i=0;i<stacksize;i++)
        {
            System.out.print(Stack[i]+"\t");
        }
        System.out.println();
    }
}
