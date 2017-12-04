public class Job extends Vertex {

    public String title;


    public Job(String label) {
        super(label);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String label) {
        this.title = label;
    }

    @Override
    public String toString() {
        return "Job{" +
                "title='" + getLabel() + '\'' +
                '}';
    }
}

