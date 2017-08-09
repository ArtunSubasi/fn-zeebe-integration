package com.camunda.consulting.zeebe.dto;

import java.util.ArrayList;
import java.util.List;

import io.zeebe.client.event.WorkflowInstanceEvent;
import io.zeebe.client.impl.data.MsgPackConverter;

public class WorkflowInstanceDto {

  public static final MsgPackConverter msgPackConverter = new MsgPackConverter();
  
  private String broker;
  private long id;
  private String workflowDefinitionUuid;

  private String workflowDefinitionKey;
  private int workflowDefinitionVersion;

  private boolean ended = false;

  private String payload;
  private List<String> runningActivities = new ArrayList<String>();
  private List<String> endedActivities = new ArrayList<String>();

  private List<IncidentDto> incidents = new ArrayList<IncidentDto>();


  public static WorkflowInstanceDto from(WorkflowInstanceEvent workflowInstanceEvent) {
    WorkflowInstanceDto dto = new WorkflowInstanceDto();
    
    dto.setWorkflowDefinitionKey(workflowInstanceEvent.getBpmnProcessId());
    dto.setWorkflowDefinitionVersion(workflowInstanceEvent.getVersion());
    dto.setId(workflowInstanceEvent.getWorkflowInstanceKey());
    
    dto.setPayload(workflowInstanceEvent.getPayload());

    return dto;
  }
  
  public String getBroker() {
    return broker;
  }

  public void setBroker(String broker) {
    this.broker = broker;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<String> getRunningActivities() {
    return runningActivities;
  }

  public void setRunningActivities(List<String> runningActivities) {
    this.runningActivities = runningActivities;
  }

  public List<String> getEndedActivities() {
    return endedActivities;
  }

  public void setEndedActivities(List<String> endedActivities) {
    this.endedActivities = endedActivities;
  }

  public boolean isEnded() {
    return ended;
  }

  public void setEnded(boolean ended) {
    this.ended = ended;
  }

  public String getWorkflowDefinitionUuid() {
    return workflowDefinitionUuid;
  }

  public void setWorkflowDefinitionUuid(String workflowDefinitionUuid) {
    this.workflowDefinitionUuid = workflowDefinitionUuid;
  }

  @Override
  public String toString() {
    return "WorkflowInstanceDto [broker=" + broker + ", id=" + id + ", workflowDefinitionUuid=" + workflowDefinitionUuid + ", ended=" + ended + ", payload="
        + payload + ", runningActivities=" + runningActivities + ", endedActivities=" + endedActivities + "]";
  }

  public String getWorkflowDefinitionKey() {
    return workflowDefinitionKey;
  }

  public void setWorkflowDefinitionKey(String workflowDefinitionKey) {
    this.workflowDefinitionKey = workflowDefinitionKey;
  }

  public int getWorkflowDefinitionVersion() {
    return workflowDefinitionVersion;
  }

  public void setWorkflowDefinitionVersion(int workflowDefinitionVersion) {
    this.workflowDefinitionVersion = workflowDefinitionVersion;
  }

  public List<IncidentDto> getIncidents() {
    return this.incidents;
  }


}