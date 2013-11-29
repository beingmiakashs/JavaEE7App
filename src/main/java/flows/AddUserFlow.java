package flows;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class AddUserFlow {
    /*@Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "addUser";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();

        flowBuilder.returnNode("success").fromOutcome("/index?faces-redirect=true");
        flowBuilder.returnNode("cancel").fromOutcome("/index?faces-redirect=true");

        return flowBuilder.getFlow();
    }*/
}
