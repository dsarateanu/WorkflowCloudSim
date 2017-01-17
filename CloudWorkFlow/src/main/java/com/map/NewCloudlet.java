package com.map;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.UtilizationModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daniel on 15-01-2017.
 */
public class NewCloudlet extends Cloudlet{

    private List<NewCloudlet> execAfterCloudlets = new ArrayList<NewCloudlet>();
    private int cloudletId;

    public NewCloudlet(int cloudletId, long cloudletLength, int pesNumber, long cloudletFileSize, long cloudletOutputSize, UtilizationModel utilizationModelCpu, UtilizationModel utilizationModelRam, UtilizationModel utilizationModelBw, List<NewCloudlet> execAfterCloudlets) {
        super(cloudletId, cloudletLength, pesNumber, cloudletFileSize, cloudletOutputSize, utilizationModelCpu, utilizationModelRam, utilizationModelBw);
        this.execAfterCloudlets = execAfterCloudlets;
    }

    public boolean verifCloudlets(){
        for(Cloudlet cloudlet : execAfterCloudlets ){
            if(cloudlet.isFinished() == false){
                return false;
            }
        }
        return true;
    }

    public List<NewCloudlet> getExecAfterCloudlets() {
        return execAfterCloudlets;
    }

    public void setExecAfterCloudlets(List<NewCloudlet> execAfterCloudlets) {
        this.execAfterCloudlets = execAfterCloudlets;
    }

    @Override
    public int getCloudletId() {
        return cloudletId;
    }

    public void setCloudletId(int cloudletId) {
        this.cloudletId = cloudletId;
    }
}
