public class ObjectOutputStreamDemo extends Student {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();

        list.add(new Student("student1", 21));
        list.add(new Student("student2", 21));
        list.add(new Student("student3", 21));
        list.add(new Student("student4", 21));
        list.add(new Student("student5", 21));
        list.add(new Student("student6", 21));
        // 写Student对象数据到文件中
    }
}
