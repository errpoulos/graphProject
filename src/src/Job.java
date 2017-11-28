public class Job {

    int requiredQualificationScore;
    String jobname;

    //constructor
    public Job (int requiredQualificationScore, String jobname) {
        this.requiredQualificationScore = requiredQualificationScore;
        this.jobname = jobname;
    }

    public int getRequiredQualificationScore() {
        return requiredQualificationScore;
    }

    public void setRequiredQualificationScore(int requiredQualificationScore) {
        this.requiredQualificationScore = requiredQualificationScore;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public Job makeJob(int requiredQualificationScore, String jobname){
        requiredQualificationScore = getRequiredQualificationScore();
        jobname = getJobname();

        return new Job (requiredQualificationScore, jobname);

    }
}
