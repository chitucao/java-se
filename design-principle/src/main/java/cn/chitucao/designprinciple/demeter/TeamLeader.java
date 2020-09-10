package cn.chitucao.designprinciple.demeter;

/**
 * Created by Tom on 2020/2/16.
 */
public class TeamLeader {

    public void commandCheckNumber(Employee employee){
        employee.checkNumberOfCourses();
    }
}
