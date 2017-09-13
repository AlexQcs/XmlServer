/**
 * Created by alex on 2017/8/14.
 */
public class FatherClass implements Comparable<FatherClass> {
    public String mFatherName;
    public int mFatherAge;

    public void printFatherMsg() {
    }

    public String getmFatherName() {
        return mFatherName;
    }

    public void setmFatherName(String mFatherName) {
        this.mFatherName = mFatherName;
    }

    public int getmFatherAge() {
        return mFatherAge;
    }

    public void setmFatherAge(int mFatherAge) {
        this.mFatherAge = mFatherAge;
    }

    @Override
    public int compareTo(FatherClass o) {
        return this.mFatherAge - o.mFatherAge;
    }
}
