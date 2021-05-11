package MyThreading.logic;

import MyThreading.be.Person;
import MyThreading.dal.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;

public class TableData extends Task<Person> {

    private DataBase dataBase;

    private static TableView tableView;
    private static ObservableList<Person> personList;

    private static int currentid;

    public TableData(){
        dataBase = new DataBase();
    }

    @Override
    protected synchronized Person call() throws Exception {
        for (int i = currentid; i < 500; i++) {
            Person person = dataBase.getPerson(i);
            personList.add(person);
            currentid++;
            Thread.sleep(100);
            if (this.isCancelled()){
                return null;
            }
        }

        return null;
    }

    public void setTableView(TableView tableView) {
        TableData.tableView = tableView;
    }

    public void setPersonList(ObservableList<Person> personList) {
        TableData.personList = personList;
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void setCurrentid(int currentid) {
        TableData.currentid = currentid;
    }


}
