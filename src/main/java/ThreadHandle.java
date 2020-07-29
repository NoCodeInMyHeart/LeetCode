import java.util.concurrent.*;

public enum ThreadHandle {
    /**
     * 单例线程池，线程调用都使用此线程池
     */
    THREADPOOL;

    private ThreadPoolExecutor executor;

    ThreadHandle(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(12,12,0, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(Integer.MAX_VALUE),
                new ThreadFactoryBuilder().setNamePrefix("FounderVehicleHistoryDataSynJob---").build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public ThreadPoolExecutor getThreadPool(){
        return executor;
    }

}
