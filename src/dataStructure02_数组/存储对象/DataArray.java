package dataStructure02_数组.存储对象;

/**
 * 2020/3/5 23:27
 *
 * @author a1344
 * 说明：
 */
public class DataArray {
    private Person[] peoples;
    private int n;

    public DataArray(int max) {
        peoples = new Person[max];
        n = 0;
    }

    public Person find(String searchName) {
        int j;
        for (j = 0; j < n; j++)
            if (peoples[j].getLastName().equals(searchName))
                break;
        if (j == n)
            return null;
        else
            return peoples[j];
    }

    public void insert(String last, String first, int age) {
        peoples[n] = new Person(last, first, age);

        n++;
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < n; j++)
            if (peoples[j].getLastName().equals(searchName))
                break;

        if (j == n)
            return false;
        else {
            for (int k=j;k<n;k++)
                peoples[k]=peoples[k+1];
            n--;
            return true;
        }
    }

    public void display(){
        for (int j =0;j<n;j++)
            System.out.println(peoples[j]);
    }
}
