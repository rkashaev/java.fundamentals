package courses.lesson10;

import java.util.ArrayList;
import java.util.List;

public class Generics02 {
    public static void main(String[] args) {
//        List<? extends Doctor> list1 = new ArrayList<MedicalStaff>(); // error
        List<? extends Doctor> list2 = new ArrayList<Doctor>();
        List<? extends Doctor> list3 = new ArrayList<HeadDoctor>();

//        list2.add(new MedicalStaff()); // error
//        list2.add(new Nurse()); // error
//        list2.add(new HeadDoctor()); // error
//        list2.add(new Doctor()); // error

        Doctor doctor = list2.get(0);

//        List<? super Doctor> list7 = new ArrayList<HeadDoctor>(); // error
        List<? super Doctor> list6 = new ArrayList<Doctor>();
        List<? super Doctor> list5 = new ArrayList<MedicalStaff>();
        List<? super Doctor> list4 = new ArrayList<Object>();

//        list5.add(new Object()); // error
//        list5.add(new MedicalStaff()); // error
//        list5.add(new Nurse());
        list5.add(new Doctor());
        list5.add(new HeadDoctor());


        Object object = list5.get(0);
//        MedicalStaff medicalDtaff = list5.get(0); // error
//        Doctor doctor = list5.get(0); // error
//        HeadDoctor headDoctor = list5.get(0); // error
    }
}

class MedicalStaff {
}

class Doctor extends MedicalStaff {
}

class HeadDoctor extends Doctor {
}

class Nurse extends MedicalStaff {
}

