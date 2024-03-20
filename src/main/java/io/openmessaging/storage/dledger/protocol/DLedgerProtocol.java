/*
 * Copyright 2017-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.openmessaging.storage.dledger.protocol;

import java.util.concurrent.CompletableFuture;

/**
 * 服务端协议
 * Both the RaftLogServer(inbound) and RaftRpcService (outbound) should implement this protocol
 */
public interface DLedgerProtocol extends DLedgerClientProtocol {

    /**
     * 发起投票请求
     */
    CompletableFuture<VoteResponse> vote(VoteRequest request) throws Exception;

    /**
     * Leader 向从节点发送心跳包
     */
    CompletableFuture<HeartBeatResponse> heartBeat(HeartBeatRequest request) throws Exception;

    /**
     * 拉取日志条目
     */
    CompletableFuture<PullEntriesResponse> pull(PullEntriesRequest request) throws Exception;

    /**
     * 推送日志条目
     */
    CompletableFuture<PushEntryResponse> push(PushEntryRequest request) throws Exception;

}
