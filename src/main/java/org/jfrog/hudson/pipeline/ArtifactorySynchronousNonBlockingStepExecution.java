package org.jfrog.hudson.pipeline;

import com.google.inject.Inject;
import hudson.EnvVars;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.Run;
import hudson.model.TaskListener;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.SynchronousNonBlockingStepExecution;

import java.io.IOException;

public abstract class ArtifactorySynchronousNonBlockingStepExecution<T> extends SynchronousNonBlockingStepExecution<T> {
    protected static final long serialVersionUID = 1L;

    protected transient Run<?, ?> build;

    protected transient TaskListener listener;

    protected transient Launcher launcher;

    protected transient FilePath ws;

    protected transient EnvVars env;

    protected ArtifactorySynchronousNonBlockingStepExecution(StepContext context) throws IOException, InterruptedException {
        super(context);
        this.build = context.get(Run.class);
        this.listener = context.get(TaskListener.class);
        this.launcher = context.get(Launcher.class);
        this.ws = context.get(FilePath.class);
        this.env = context.get(EnvVars.class);

    }
}
