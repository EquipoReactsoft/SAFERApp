package com.reactsoft.safer.ui.locator;

import com.reactsoft.safer.domain.executor.PostExecutor;
import com.reactsoft.safer.domain.executor.ThreadExecutor;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.executor.UseCaseExecutorLocator;
import com.reactsoft.safer.ui.executor.JobExecutor;
import com.reactsoft.safer.ui.executor.UIExecutor;


public class AppServiceLocator implements UseCaseExecutorLocator {
  private ThreadExecutor threadExecutor;
  private PostExecutor postExecutor;
  private UseCaseExecutor useCaseExecutor;

  public static AppServiceLocator getInstance() {
    return Instance.instance;
  }

  @Override
  public ThreadExecutor threadExecutor() {
    if (threadExecutor == null) {
      threadExecutor = new JobExecutor();
    }
    return threadExecutor;
  }

  @Override
  public PostExecutor postExecutor() {
    if (postExecutor == null) {
      postExecutor = new UIExecutor();
    }
    return postExecutor;
  }

  @Override
  public UseCaseExecutor useCaseExecutor() {
    if (useCaseExecutor == null) {
      useCaseExecutor = new UseCaseExecutor(threadExecutor(), postExecutor());
    }
    return useCaseExecutor;
  }

  public ActivityServiceLocator plusActivityServiceLocator() {
    return new ActivityServiceLocator();
  }

  private static class Instance {
    private static final AppServiceLocator instance = new AppServiceLocator();
  }
}
