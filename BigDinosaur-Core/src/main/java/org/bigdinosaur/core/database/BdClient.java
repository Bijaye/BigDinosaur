package org.bigdinosaur.core.database;
//Big Dinosaur has many clients on the basis of evolution of api it goes on 
//for mapreduce it has following clients 
//Client types:BdCoreClient,BdCommonClient,BdAppClient,BdHistoryClient,BdJobClient
// for every client of map reduce unit test is necessary starting from core client 
public interface BdClient
{
Object readFiles();
Object readBlocks();
Object createBlock();
Object deleteBlock();
Object replicateBlock();
Object AccessLogService();
Object FieldNameService();
Object MessageService();
Object PostConditionService();
Object PreconditionService();
Object PreferenceService();
Object SessionContext();
void deleteLogInSuccess();
public abstract String getLanguage();
public abstract String getpreference();

void deleteSuccessDBOnly();
public abstract String getPgmId();

void resetContext();
void log();
public abstract Object lock(String key, String refKey, String fileId,
                            String exclusiveKey1, String exclusiveKey2, String workStationId,
                            String moduleid, String packageid, String businessid);

                        public abstract Object unlock(String key, String refKey, String fileId,
                            String exclusiveKey1, String exclusiveKey2, String workStationId,
                            String moduleid, String packageid, String businessid,
                            String repoid, String documentid);


}
