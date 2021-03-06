/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.identitymanagement;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

import com.amazonaws.services.identitymanagement.model.*;

/**
 * Asynchronous client for accessing AmazonIdentityManagement.
 * All asynchronous calls made using this client are non-blocking. Callers could either
 * process the result and handle the exceptions in the worker thread by providing a callback handler
 * when making the call, or use the returned Future object to check the result of the call in the calling thread.
 * AWS Identity and Access Management <p>
 * AWS Identity and Access Management (IAM) is a web service that you can
 * use to manage users and user permissions under your AWS account. This
 * guide provides descriptions of IAM actions that you can call
 * programmatically. For general information about IAM, see
 * <a href="http://aws.amazon.com/iam/"> AWS Identity and Access Management (IAM) </a> . For the user guide for IAM, see <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/"> Using IAM </a>
 * .
 * </p>
 * <p>
 * <b>NOTE:</b>AWS provides SDKs that consist of libraries and sample
 * code for various programming languages and platforms (Java, Ruby,
 * .NET, iOS, Android, etc.). The SDKs provide a convenient way to create
 * programmatic access to IAM and AWS. For example, the SDKs take care of
 * tasks such as cryptographically signing requests (see below), managing
 * errors, and retrying requests automatically. For information about the
 * AWS SDKs, including how to download and install them, see the Tools
 * for Amazon Web Services page.
 * </p>
 * <p>
 * We recommend that you use the AWS SDKs to make programmatic API calls
 * to IAM. However, you can also use the IAM Query API to make direct
 * calls to the IAM web service. To learn more about the IAM Query API,
 * see
 * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/IAM_UsingQueryAPI.html"> Making Query Requests </a>
 * in the <i>Using IAM</i> guide. IAM supports GET and POST requests
 * for all actions. That is, the API does not require you to use GET for
 * some actions and POST for others. However, GET requests are subject to
 * the limitation size of a URL. Therefore, for operations that require
 * larger sizes, use a POST request.
 * </p>
 * <p>
 * <b>Signing Requests</b>
 * </p>
 * <p>
 * Requests must be signed using an access key ID and a secret access
 * key. We strongly recommend that you do not use your AWS account access
 * key ID and secret access key for everyday work with IAM. You can use
 * the access key ID and secret access key for an IAM user or you can use
 * the AWS Security Token Service to generate temporary security
 * credentials and use those to sign requests.
 * </p>
 * <p>
 * To sign requests, we recommend that you use
 * <a href="http://docs.aws.amazon.com/general/latest/gr/signature-version-4.html"> Signature Version 4 </a>
 * . If you have an existing application that uses Signature Version 2,
 * you do not have to update it to use Signature Version 4. However, some
 * operations now require Signature Version 4. The documentation for
 * operations that require version 4 indicate this requirement.
 * </p>
 * <p>
 * <b>Additional Resources</b>
 * </p>
 * <p>
 * For more information, see the following:
 * </p>
 * 
 * <ul>
 * <li>
 * <a href="http://docs.aws.amazon.com/general/latest/gr/aws-security-credentials.html"> AWS Security Credentials </a>
 * . This topic provides general information about the types of
 * credentials used for accessing AWS. </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html"> IAM Best Practices </a>
 * . This topic presents a list of suggestions for using the IAM service
 * to help secure your AWS resources. </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/general/latest/gr/signing_aws_api_requests.html"> Signing AWS API Requests </a>
 * . This set of topics walk you through the process of signing a
 * request using an access key ID and secret access key. </li>
 * 
 * </ul>
 */
public class AmazonIdentityManagementAsyncClient extends AmazonIdentityManagementClient
        implements AmazonIdentityManagementAsync {

    /**
     * Executor service for executing asynchronous requests.
     */
    private final ExecutorService executorService;

    private static final int DEFAULT_THREAD_POOL_SIZE = 50;

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonIdentityManagementAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonIdentityManagement
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonIdentityManagementAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement using the specified AWS account credentials.
     * Default client settings will be used, and a fixed size thread pool will be
     * created for executing the asynchronous tasks.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonIdentityManagementAsyncClient(AWSCredentials awsCredentials) {
        this(awsCredentials, Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement using the specified AWS account credentials
     * and executor service.  Default client settings will be used.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials
     *            The AWS credentials (access key ID and secret key) to use
     *            when authenticating with AWS services.
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonIdentityManagementAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService) {
        super(awsCredentials);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement using the specified AWS account credentials,
     * executor service, and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials
     *            The AWS credentials (access key ID and secret key) to use
     *            when authenticating with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonIdentityManagementAsyncClient(AWSCredentials awsCredentials,
                ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement using the specified AWS account credentials provider.
     * Default client settings will be used, and a fixed size thread pool will be
     * created for executing the asynchronous tasks.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonIdentityManagementAsyncClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement using the specified AWS account credentials provider
     * and executor service.  Default client settings will be used.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonIdentityManagementAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService) {
        this(awsCredentialsProvider, new ClientConfiguration(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     */
    public AmazonIdentityManagementAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
                ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonIdentityManagement using the specified AWS account credentials
     * provider, executor service, and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonIdentityManagementAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
                ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Returns the executor service used by this async client to execute
     * requests.
     *
     * @return The executor service used by this async client to execute
     *         requests.
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * Shuts down the client, releasing all managed resources. This includes
     * forcibly terminating all pending asynchronous service calls. Clients who
     * wish to give pending asynchronous service calls time to complete should
     * call getExecutorService().shutdown() followed by
     * getExecutorService().awaitTermination() prior to calling this method.
     */
    @Override
    public void shutdown() {
        super.shutdown();
        executorService.shutdownNow();
    }
            
    /**
     * <p>
     * Deletes the specified AWS account alias. For information about using
     * an AWS account alias, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html"> Using an Alias for Your AWS Account ID </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deleteAccountAliasRequest Container for the necessary
     *           parameters to execute the DeleteAccountAlias operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAccountAlias service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAccountAliasAsync(final DeleteAccountAliasRequest deleteAccountAliasRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteAccountAlias(deleteAccountAliasRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified AWS account alias. For information about using
     * an AWS account alias, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html"> Using an Alias for Your AWS Account ID </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deleteAccountAliasRequest Container for the necessary
     *           parameters to execute the DeleteAccountAlias operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAccountAlias service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAccountAliasAsync(
            final DeleteAccountAliasRequest deleteAccountAliasRequest,
            final AsyncHandler<DeleteAccountAliasRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteAccountAlias(deleteAccountAliasRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteAccountAliasRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists the groups that have the specified path prefix.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listGroupsRequest Container for the necessary parameters to
     *           execute the ListGroups operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListGroups service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListGroupsResult> listGroupsAsync(final ListGroupsRequest listGroupsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListGroupsResult>() {
            public ListGroupsResult call() throws Exception {
                return listGroups(listGroupsRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the groups that have the specified path prefix.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listGroupsRequest Container for the necessary parameters to
     *           execute the ListGroups operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListGroups service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListGroupsResult> listGroupsAsync(
            final ListGroupsRequest listGroupsRequest,
            final AsyncHandler<ListGroupsRequest, ListGroupsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListGroupsResult>() {
            public ListGroupsResult call() throws Exception {
              ListGroupsResult result;
                try {
                result = listGroups(listGroupsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listGroupsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes a virtual MFA device.
     * </p>
     * <p>
     * <b>NOTE:</b> You must deactivate a user's virtual MFA device before
     * you can delete it. For information about deactivating MFA devices, see
     * DeactivateMFADevice.
     * </p>
     *
     * @param deleteVirtualMFADeviceRequest Container for the necessary
     *           parameters to execute the DeleteVirtualMFADevice operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteVirtualMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteVirtualMFADeviceAsync(final DeleteVirtualMFADeviceRequest deleteVirtualMFADeviceRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteVirtualMFADevice(deleteVirtualMFADeviceRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes a virtual MFA device.
     * </p>
     * <p>
     * <b>NOTE:</b> You must deactivate a user's virtual MFA device before
     * you can delete it. For information about deactivating MFA devices, see
     * DeactivateMFADevice.
     * </p>
     *
     * @param deleteVirtualMFADeviceRequest Container for the necessary
     *           parameters to execute the DeleteVirtualMFADevice operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteVirtualMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteVirtualMFADeviceAsync(
            final DeleteVirtualMFADeviceRequest deleteVirtualMFADeviceRequest,
            final AsyncHandler<DeleteVirtualMFADeviceRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteVirtualMFADevice(deleteVirtualMFADeviceRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteVirtualMFADeviceRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Adds (or updates) an inline policy document that is embedded in the
     * specified user.
     * </p>
     * <p>
     * A user can also have a managed policy attached to it. To attach a
     * managed policy to a user, use AttachUserPolicy. To create a new
     * managed policy, use CreatePolicy. For information about policies,
     * refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For information about limits on the number of inline policies that
     * you can embed in a user, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b>Because policy documents can be large, you should use
     * POST rather than GET when calling PutUserPolicy. For general
     * information about using the Query API with IAM, go to Making Query
     * Requests in the Using IAM guide.
     * </p>
     *
     * @param putUserPolicyRequest Container for the necessary parameters to
     *           execute the PutUserPolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         PutUserPolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putUserPolicyAsync(final PutUserPolicyRequest putUserPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                putUserPolicy(putUserPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Adds (or updates) an inline policy document that is embedded in the
     * specified user.
     * </p>
     * <p>
     * A user can also have a managed policy attached to it. To attach a
     * managed policy to a user, use AttachUserPolicy. To create a new
     * managed policy, use CreatePolicy. For information about policies,
     * refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For information about limits on the number of inline policies that
     * you can embed in a user, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b>Because policy documents can be large, you should use
     * POST rather than GET when calling PutUserPolicy. For general
     * information about using the Query API with IAM, go to Making Query
     * Requests in the Using IAM guide.
     * </p>
     *
     * @param putUserPolicyRequest Container for the necessary parameters to
     *           execute the PutUserPolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         PutUserPolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putUserPolicyAsync(
            final PutUserPolicyRequest putUserPolicyRequest,
            final AsyncHandler<PutUserPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                putUserPolicy(putUserPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(putUserPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns information about the SSH public keys associated with the
     * specified IAM user. If there are none, the action returns an empty
     * list.
     * </p>
     * <p>
     * The SSH public keys returned by this action are used only for
     * authenticating the IAM user to an AWS CodeCommit repository. For more
     * information about using SSH keys to authenticate to an AWS CodeCommit
     * repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     * <p>
     * Although each user is limited to a small number of keys, you can
     * still paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listSSHPublicKeysRequest Container for the necessary parameters
     *           to execute the ListSSHPublicKeys operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListSSHPublicKeys service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(final ListSSHPublicKeysRequest listSSHPublicKeysRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSSHPublicKeysResult>() {
            public ListSSHPublicKeysResult call() throws Exception {
                return listSSHPublicKeys(listSSHPublicKeysRequest);
        }
    });
    }

    /**
     * <p>
     * Returns information about the SSH public keys associated with the
     * specified IAM user. If there are none, the action returns an empty
     * list.
     * </p>
     * <p>
     * The SSH public keys returned by this action are used only for
     * authenticating the IAM user to an AWS CodeCommit repository. For more
     * information about using SSH keys to authenticate to an AWS CodeCommit
     * repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     * <p>
     * Although each user is limited to a small number of keys, you can
     * still paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listSSHPublicKeysRequest Container for the necessary parameters
     *           to execute the ListSSHPublicKeys operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListSSHPublicKeys service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(
            final ListSSHPublicKeysRequest listSSHPublicKeysRequest,
            final AsyncHandler<ListSSHPublicKeysRequest, ListSSHPublicKeysResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSSHPublicKeysResult>() {
            public ListSSHPublicKeysResult call() throws Exception {
              ListSSHPublicKeysResult result;
                try {
                result = listSSHPublicKeys(listSSHPublicKeysRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listSSHPublicKeysRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists the SAML providers in the account.
     * </p>
     * <p>
     * <b>NOTE:</b> This operation requires Signature Version 4.
     * </p>
     *
     * @param listSAMLProvidersRequest Container for the necessary parameters
     *           to execute the ListSAMLProviders operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListSAMLProviders service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListSAMLProvidersResult> listSAMLProvidersAsync(final ListSAMLProvidersRequest listSAMLProvidersRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSAMLProvidersResult>() {
            public ListSAMLProvidersResult call() throws Exception {
                return listSAMLProviders(listSAMLProvidersRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the SAML providers in the account.
     * </p>
     * <p>
     * <b>NOTE:</b> This operation requires Signature Version 4.
     * </p>
     *
     * @param listSAMLProvidersRequest Container for the necessary parameters
     *           to execute the ListSAMLProviders operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListSAMLProviders service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListSAMLProvidersResult> listSAMLProvidersAsync(
            final ListSAMLProvidersRequest listSAMLProvidersRequest,
            final AsyncHandler<ListSAMLProvidersRequest, ListSAMLProvidersResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSAMLProvidersResult>() {
            public ListSAMLProvidersResult call() throws Exception {
              ListSAMLProvidersResult result;
                try {
                result = listSAMLProviders(listSAMLProvidersRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listSAMLProvidersRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves the specified inline policy document that is embedded in
     * the specified user.
     * </p>
     * <p>
     * A user can also have managed policies attached to it. To retrieve a
     * managed policy document that is attached to a user, use GetPolicy to
     * determine the policy's default version, then use GetPolicyVersion to
     * retrieve the policy document.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getUserPolicyRequest Container for the necessary parameters to
     *           execute the GetUserPolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetUserPolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetUserPolicyResult> getUserPolicyAsync(final GetUserPolicyRequest getUserPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetUserPolicyResult>() {
            public GetUserPolicyResult call() throws Exception {
                return getUserPolicy(getUserPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves the specified inline policy document that is embedded in
     * the specified user.
     * </p>
     * <p>
     * A user can also have managed policies attached to it. To retrieve a
     * managed policy document that is attached to a user, use GetPolicy to
     * determine the policy's default version, then use GetPolicyVersion to
     * retrieve the policy document.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getUserPolicyRequest Container for the necessary parameters to
     *           execute the GetUserPolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetUserPolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetUserPolicyResult> getUserPolicyAsync(
            final GetUserPolicyRequest getUserPolicyRequest,
            final AsyncHandler<GetUserPolicyRequest, GetUserPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetUserPolicyResult>() {
            public GetUserPolicyResult call() throws Exception {
              GetUserPolicyResult result;
                try {
                result = getUserPolicy(getUserPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getUserPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes an IAM OpenID Connect identity provider.
     * </p>
     * <p>
     * Deleting an OIDC provider does not update any roles that reference
     * the provider as a principal in their trust policies. Any attempt to
     * assume a role that references a provider that has been deleted will
     * fail.
     * </p>
     * <p>
     * This action is idempotent; it does not fail or return an error if you
     * call the action for a provider that was already deleted.
     * </p>
     *
     * @param deleteOpenIDConnectProviderRequest Container for the necessary
     *           parameters to execute the DeleteOpenIDConnectProvider operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteOpenIDConnectProviderAsync(final DeleteOpenIDConnectProviderRequest deleteOpenIDConnectProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteOpenIDConnectProvider(deleteOpenIDConnectProviderRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes an IAM OpenID Connect identity provider.
     * </p>
     * <p>
     * Deleting an OIDC provider does not update any roles that reference
     * the provider as a principal in their trust policies. Any attempt to
     * assume a role that references a provider that has been deleted will
     * fail.
     * </p>
     * <p>
     * This action is idempotent; it does not fail or return an error if you
     * call the action for a provider that was already deleted.
     * </p>
     *
     * @param deleteOpenIDConnectProviderRequest Container for the necessary
     *           parameters to execute the DeleteOpenIDConnectProvider operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteOpenIDConnectProviderAsync(
            final DeleteOpenIDConnectProviderRequest deleteOpenIDConnectProviderRequest,
            final AsyncHandler<DeleteOpenIDConnectProviderRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteOpenIDConnectProvider(deleteOpenIDConnectProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteOpenIDConnectProviderRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Changes the status of the specified signing certificate from active
     * to disabled, or vice versa. This action can be used to disable a
     * user's signing certificate as part of a certificate rotation work
     * flow.
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the UserName is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     *
     * @param updateSigningCertificateRequest Container for the necessary
     *           parameters to execute the UpdateSigningCertificate operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateSigningCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateSigningCertificateAsync(final UpdateSigningCertificateRequest updateSigningCertificateRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateSigningCertificate(updateSigningCertificateRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Changes the status of the specified signing certificate from active
     * to disabled, or vice versa. This action can be used to disable a
     * user's signing certificate as part of a certificate rotation work
     * flow.
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the UserName is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     *
     * @param updateSigningCertificateRequest Container for the necessary
     *           parameters to execute the UpdateSigningCertificate operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateSigningCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateSigningCertificateAsync(
            final UpdateSigningCertificateRequest updateSigningCertificateRequest,
            final AsyncHandler<UpdateSigningCertificateRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateSigningCertificate(updateSigningCertificateRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateSigningCertificateRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists the IAM users that have the specified path prefix. If no path
     * prefix is specified, the action returns all users in the AWS account.
     * If there are none, the action returns an empty list.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listUsersRequest Container for the necessary parameters to
     *           execute the ListUsers operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListUsers service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListUsersResult> listUsersAsync(final ListUsersRequest listUsersRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUsersResult>() {
            public ListUsersResult call() throws Exception {
                return listUsers(listUsersRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the IAM users that have the specified path prefix. If no path
     * prefix is specified, the action returns all users in the AWS account.
     * If there are none, the action returns an empty list.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listUsersRequest Container for the necessary parameters to
     *           execute the ListUsers operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListUsers service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListUsersResult> listUsersAsync(
            final ListUsersRequest listUsersRequest,
            final AsyncHandler<ListUsersRequest, ListUsersResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUsersResult>() {
            public ListUsersResult call() throws Exception {
              ListUsersResult result;
                try {
                result = listUsers(listUsersRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listUsersRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Attaches the specified managed policy to the specified role.
     * </p>
     * <p>
     * When you attach a managed policy to a role, the managed policy is
     * used as the role's access (permissions) policy. You cannot use a
     * managed policy as the role's trust policy. The role's trust policy is
     * created at the same time as the role, using CreateRole. You can update
     * a role's trust policy using UpdateAssumeRolePolicy.
     * </p>
     * <p>
     * Use this API to attach a managed policy to a role. To embed an inline
     * policy in a role, use PutRolePolicy. For more information about
     * policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param attachRolePolicyRequest Container for the necessary parameters
     *           to execute the AttachRolePolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         AttachRolePolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> attachRolePolicyAsync(final AttachRolePolicyRequest attachRolePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                attachRolePolicy(attachRolePolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Attaches the specified managed policy to the specified role.
     * </p>
     * <p>
     * When you attach a managed policy to a role, the managed policy is
     * used as the role's access (permissions) policy. You cannot use a
     * managed policy as the role's trust policy. The role's trust policy is
     * created at the same time as the role, using CreateRole. You can update
     * a role's trust policy using UpdateAssumeRolePolicy.
     * </p>
     * <p>
     * Use this API to attach a managed policy to a role. To embed an inline
     * policy in a role, use PutRolePolicy. For more information about
     * policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param attachRolePolicyRequest Container for the necessary parameters
     *           to execute the AttachRolePolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         AttachRolePolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> attachRolePolicyAsync(
            final AttachRolePolicyRequest attachRolePolicyRequest,
            final AsyncHandler<AttachRolePolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                attachRolePolicy(attachRolePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(attachRolePolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Gets a list of all of the context keys referenced in
     * <code>Condition</code> elements in the input policies. The policies
     * are supplied as a list of one or more strings. To get the context keys
     * from policies associated with an IAM user, group, or role, use
     * GetContextKeysForPrincipalPolicy.
     * </p>
     * <p>
     * Context keys are variables maintained by AWS and its services that
     * provide details about the context of an API query request, and can be
     * evaluated by using the <code>Condition</code> element of an IAM
     * policy. Use GetContextKeysForCustomPolicy to understand what key names
     * and values you must supply when you call SimulateCustomPolicy. Note
     * that all parameters are shown in unencoded form here for clarity, but
     * must be URL encoded to be included as a part of a real HTML request.
     * </p>
     *
     * @param getContextKeysForCustomPolicyRequest Container for the
     *           necessary parameters to execute the GetContextKeysForCustomPolicy
     *           operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetContextKeysForCustomPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetContextKeysForCustomPolicyResult> getContextKeysForCustomPolicyAsync(final GetContextKeysForCustomPolicyRequest getContextKeysForCustomPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetContextKeysForCustomPolicyResult>() {
            public GetContextKeysForCustomPolicyResult call() throws Exception {
                return getContextKeysForCustomPolicy(getContextKeysForCustomPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Gets a list of all of the context keys referenced in
     * <code>Condition</code> elements in the input policies. The policies
     * are supplied as a list of one or more strings. To get the context keys
     * from policies associated with an IAM user, group, or role, use
     * GetContextKeysForPrincipalPolicy.
     * </p>
     * <p>
     * Context keys are variables maintained by AWS and its services that
     * provide details about the context of an API query request, and can be
     * evaluated by using the <code>Condition</code> element of an IAM
     * policy. Use GetContextKeysForCustomPolicy to understand what key names
     * and values you must supply when you call SimulateCustomPolicy. Note
     * that all parameters are shown in unencoded form here for clarity, but
     * must be URL encoded to be included as a part of a real HTML request.
     * </p>
     *
     * @param getContextKeysForCustomPolicyRequest Container for the
     *           necessary parameters to execute the GetContextKeysForCustomPolicy
     *           operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetContextKeysForCustomPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetContextKeysForCustomPolicyResult> getContextKeysForCustomPolicyAsync(
            final GetContextKeysForCustomPolicyRequest getContextKeysForCustomPolicyRequest,
            final AsyncHandler<GetContextKeysForCustomPolicyRequest, GetContextKeysForCustomPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetContextKeysForCustomPolicyResult>() {
            public GetContextKeysForCustomPolicyResult call() throws Exception {
              GetContextKeysForCustomPolicyResult result;
                try {
                result = getContextKeysForCustomPolicy(getContextKeysForCustomPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getContextKeysForCustomPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves a credential report for the AWS account. For more
     * information about the credential report, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/credential-reports.html"> Getting Credential Reports </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getCredentialReportRequest Container for the necessary
     *           parameters to execute the GetCredentialReport operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetCredentialReport service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetCredentialReportResult> getCredentialReportAsync(final GetCredentialReportRequest getCredentialReportRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetCredentialReportResult>() {
            public GetCredentialReportResult call() throws Exception {
                return getCredentialReport(getCredentialReportRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves a credential report for the AWS account. For more
     * information about the credential report, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/credential-reports.html"> Getting Credential Reports </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getCredentialReportRequest Container for the necessary
     *           parameters to execute the GetCredentialReport operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetCredentialReport service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetCredentialReportResult> getCredentialReportAsync(
            final GetCredentialReportRequest getCredentialReportRequest,
            final AsyncHandler<GetCredentialReportRequest, GetCredentialReportResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetCredentialReportResult>() {
            public GetCredentialReportResult call() throws Exception {
              GetCredentialReportResult result;
                try {
                result = getCredentialReport(getCredentialReportRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getCredentialReportRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Enables the specified MFA device and associates it with the specified
     * user name. When enabled, the MFA device is required for every
     * subsequent login by the user name associated with the device.
     * </p>
     *
     * @param enableMFADeviceRequest Container for the necessary parameters
     *           to execute the EnableMFADevice operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         EnableMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> enableMFADeviceAsync(final EnableMFADeviceRequest enableMFADeviceRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                enableMFADevice(enableMFADeviceRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Enables the specified MFA device and associates it with the specified
     * user name. When enabled, the MFA device is required for every
     * subsequent login by the user name associated with the device.
     * </p>
     *
     * @param enableMFADeviceRequest Container for the necessary parameters
     *           to execute the EnableMFADevice operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         EnableMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> enableMFADeviceAsync(
            final EnableMFADeviceRequest enableMFADeviceRequest,
            final AsyncHandler<EnableMFADeviceRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                enableMFADevice(enableMFADeviceRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(enableMFADeviceRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the password policy for the AWS account.
     * </p>
     *
     * @param deleteAccountPasswordPolicyRequest Container for the necessary
     *           parameters to execute the DeleteAccountPasswordPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAccountPasswordPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAccountPasswordPolicyAsync(final DeleteAccountPasswordPolicyRequest deleteAccountPasswordPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteAccountPasswordPolicy(deleteAccountPasswordPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the password policy for the AWS account.
     * </p>
     *
     * @param deleteAccountPasswordPolicyRequest Container for the necessary
     *           parameters to execute the DeleteAccountPasswordPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAccountPasswordPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAccountPasswordPolicyAsync(
            final DeleteAccountPasswordPolicyRequest deleteAccountPasswordPolicyRequest,
            final AsyncHandler<DeleteAccountPasswordPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteAccountPasswordPolicy(deleteAccountPasswordPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteAccountPasswordPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves the user name and password-creation date for the specified
     * user. If the user has not been assigned a password, the action returns
     * a 404 ( <code>NoSuchEntity</code> ) error.
     * </p>
     *
     * @param getLoginProfileRequest Container for the necessary parameters
     *           to execute the GetLoginProfile operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetLoginProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetLoginProfileResult> getLoginProfileAsync(final GetLoginProfileRequest getLoginProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetLoginProfileResult>() {
            public GetLoginProfileResult call() throws Exception {
                return getLoginProfile(getLoginProfileRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves the user name and password-creation date for the specified
     * user. If the user has not been assigned a password, the action returns
     * a 404 ( <code>NoSuchEntity</code> ) error.
     * </p>
     *
     * @param getLoginProfileRequest Container for the necessary parameters
     *           to execute the GetLoginProfile operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetLoginProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetLoginProfileResult> getLoginProfileAsync(
            final GetLoginProfileRequest getLoginProfileRequest,
            final AsyncHandler<GetLoginProfileRequest, GetLoginProfileResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetLoginProfileResult>() {
            public GetLoginProfileResult call() throws Exception {
              GetLoginProfileResult result;
                try {
                result = getLoginProfile(getLoginProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getLoginProfileRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Updates the metadata document for an existing SAML provider.
     * </p>
     * <p>
     * <b>NOTE:</b>This operation requires Signature Version 4.
     * </p>
     *
     * @param updateSAMLProviderRequest Container for the necessary
     *           parameters to execute the UpdateSAMLProvider operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateSAMLProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<UpdateSAMLProviderResult> updateSAMLProviderAsync(final UpdateSAMLProviderRequest updateSAMLProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateSAMLProviderResult>() {
            public UpdateSAMLProviderResult call() throws Exception {
                return updateSAMLProvider(updateSAMLProviderRequest);
        }
    });
    }

    /**
     * <p>
     * Updates the metadata document for an existing SAML provider.
     * </p>
     * <p>
     * <b>NOTE:</b>This operation requires Signature Version 4.
     * </p>
     *
     * @param updateSAMLProviderRequest Container for the necessary
     *           parameters to execute the UpdateSAMLProvider operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateSAMLProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<UpdateSAMLProviderResult> updateSAMLProviderAsync(
            final UpdateSAMLProviderRequest updateSAMLProviderRequest,
            final AsyncHandler<UpdateSAMLProviderRequest, UpdateSAMLProviderResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateSAMLProviderResult>() {
            public UpdateSAMLProviderResult call() throws Exception {
              UpdateSAMLProviderResult result;
                try {
                result = updateSAMLProvider(updateSAMLProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateSAMLProviderRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Uploads a server certificate entity for the AWS account. The server
     * certificate entity includes a public key certificate, a private key,
     * and an optional certificate chain, which should all be PEM-encoded.
     * </p>
     * <p>
     * For information about the number of server certificates you can
     * upload, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b>Because the body of the public key certificate, private
     * key, and the certificate chain can be large, you should use POST
     * rather than GET when calling UploadServerCertificate. For information
     * about setting up signatures and authorization through the API, go to
     * Signing AWS API Requests in the AWS General Reference. For general
     * information about using the Query API with IAM, go to Making Query
     * Requests in the IAM User Guide.
     * </p>
     *
     * @param uploadServerCertificateRequest Container for the necessary
     *           parameters to execute the UploadServerCertificate operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UploadServerCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<UploadServerCertificateResult> uploadServerCertificateAsync(final UploadServerCertificateRequest uploadServerCertificateRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UploadServerCertificateResult>() {
            public UploadServerCertificateResult call() throws Exception {
                return uploadServerCertificate(uploadServerCertificateRequest);
        }
    });
    }

    /**
     * <p>
     * Uploads a server certificate entity for the AWS account. The server
     * certificate entity includes a public key certificate, a private key,
     * and an optional certificate chain, which should all be PEM-encoded.
     * </p>
     * <p>
     * For information about the number of server certificates you can
     * upload, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b>Because the body of the public key certificate, private
     * key, and the certificate chain can be large, you should use POST
     * rather than GET when calling UploadServerCertificate. For information
     * about setting up signatures and authorization through the API, go to
     * Signing AWS API Requests in the AWS General Reference. For general
     * information about using the Query API with IAM, go to Making Query
     * Requests in the IAM User Guide.
     * </p>
     *
     * @param uploadServerCertificateRequest Container for the necessary
     *           parameters to execute the UploadServerCertificate operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UploadServerCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<UploadServerCertificateResult> uploadServerCertificateAsync(
            final UploadServerCertificateRequest uploadServerCertificateRequest,
            final AsyncHandler<UploadServerCertificateRequest, UploadServerCertificateResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UploadServerCertificateResult>() {
            public UploadServerCertificateResult call() throws Exception {
              UploadServerCertificateResult result;
                try {
                result = uploadServerCertificate(uploadServerCertificateRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(uploadServerCertificateRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates an alias for your AWS account. For information about using an
     * AWS account alias, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html"> Using an Alias for Your AWS Account ID </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createAccountAliasRequest Container for the necessary
     *           parameters to execute the CreateAccountAlias operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateAccountAlias service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createAccountAliasAsync(final CreateAccountAliasRequest createAccountAliasRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                createAccountAlias(createAccountAliasRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Creates an alias for your AWS account. For information about using an
     * AWS account alias, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html"> Using an Alias for Your AWS Account ID </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createAccountAliasRequest Container for the necessary
     *           parameters to execute the CreateAccountAlias operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateAccountAlias service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createAccountAliasAsync(
            final CreateAccountAliasRequest createAccountAliasRequest,
            final AsyncHandler<CreateAccountAliasRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                createAccountAlias(createAccountAliasRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createAccountAliasRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists all managed policies that are attached to the specified user.
     * </p>
     * <p>
     * A user can also have inline policies embedded with it. To list the
     * inline policies for a user, use the ListUserPolicies API. For
     * information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. You can use the
     * <code>PathPrefix</code> parameter to limit the list of policies to
     * only those matching the specified path prefix. If there are no
     * policies attached to the specified group (or none that match the
     * specified path prefix), the action returns an empty list.
     * </p>
     *
     * @param listAttachedUserPoliciesRequest Container for the necessary
     *           parameters to execute the ListAttachedUserPolicies operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListAttachedUserPolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAttachedUserPoliciesResult> listAttachedUserPoliciesAsync(final ListAttachedUserPoliciesRequest listAttachedUserPoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAttachedUserPoliciesResult>() {
            public ListAttachedUserPoliciesResult call() throws Exception {
                return listAttachedUserPolicies(listAttachedUserPoliciesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists all managed policies that are attached to the specified user.
     * </p>
     * <p>
     * A user can also have inline policies embedded with it. To list the
     * inline policies for a user, use the ListUserPolicies API. For
     * information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. You can use the
     * <code>PathPrefix</code> parameter to limit the list of policies to
     * only those matching the specified path prefix. If there are no
     * policies attached to the specified group (or none that match the
     * specified path prefix), the action returns an empty list.
     * </p>
     *
     * @param listAttachedUserPoliciesRequest Container for the necessary
     *           parameters to execute the ListAttachedUserPolicies operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListAttachedUserPolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAttachedUserPoliciesResult> listAttachedUserPoliciesAsync(
            final ListAttachedUserPoliciesRequest listAttachedUserPoliciesRequest,
            final AsyncHandler<ListAttachedUserPoliciesRequest, ListAttachedUserPoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAttachedUserPoliciesResult>() {
            public ListAttachedUserPoliciesResult call() throws Exception {
              ListAttachedUserPoliciesResult result;
                try {
                result = listAttachedUserPolicies(listAttachedUserPoliciesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listAttachedUserPoliciesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified managed policy.
     * </p>
     * <p>
     * Before you can delete a managed policy, you must detach the policy
     * from all users, groups, and roles that it is attached to, and you must
     * delete all of the policy's versions. The following steps describe the
     * process for deleting a managed policy: <ol> <li>Detach the policy from
     * all users, groups, and roles that the policy is attached to, using the
     * DetachUserPolicy, DetachGroupPolicy, or DetachRolePolicy APIs. To list
     * all the users, groups, and roles that a policy is attached to, use
     * ListEntitiesForPolicy. </li>
     * <li>Delete all versions of the policy using DeletePolicyVersion. To
     * list the policy's versions, use ListPolicyVersions. You cannot use
     * DeletePolicyVersion to delete the version that is marked as the
     * default version. You delete the policy's default version in the next
     * step of the process. </li>
     * <li>Delete the policy (this automatically deletes the policy's
     * default version) using this API. </li>
     * </ol>
     * </p>
     * <p>
     * For information about managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deletePolicyRequest Container for the necessary parameters to
     *           execute the DeletePolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeletePolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deletePolicyAsync(final DeletePolicyRequest deletePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deletePolicy(deletePolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified managed policy.
     * </p>
     * <p>
     * Before you can delete a managed policy, you must detach the policy
     * from all users, groups, and roles that it is attached to, and you must
     * delete all of the policy's versions. The following steps describe the
     * process for deleting a managed policy: <ol> <li>Detach the policy from
     * all users, groups, and roles that the policy is attached to, using the
     * DetachUserPolicy, DetachGroupPolicy, or DetachRolePolicy APIs. To list
     * all the users, groups, and roles that a policy is attached to, use
     * ListEntitiesForPolicy. </li>
     * <li>Delete all versions of the policy using DeletePolicyVersion. To
     * list the policy's versions, use ListPolicyVersions. You cannot use
     * DeletePolicyVersion to delete the version that is marked as the
     * default version. You delete the policy's default version in the next
     * step of the process. </li>
     * <li>Delete the policy (this automatically deletes the policy's
     * default version) using this API. </li>
     * </ol>
     * </p>
     * <p>
     * For information about managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deletePolicyRequest Container for the necessary parameters to
     *           execute the DeletePolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeletePolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deletePolicyAsync(
            final DeletePolicyRequest deletePolicyRequest,
            final AsyncHandler<DeletePolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deletePolicy(deletePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deletePolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Simulate a set of IAM policies against a list of API actions and AWS
     * resources to determine the policies' effective permissions. The
     * policies are provided as a list of strings.
     * </p>
     * <p>
     * The simulation does not perform the API actions, it only checks the
     * authorization to determine if the simulated policies allow or deny the
     * actions.
     * </p>
     * <p>
     * If you want to simulate existing policies attached to an IAM user,
     * group, or role, use SimulatePrincipalPolicy instead.
     * </p>
     * <p>
     * Context keys are variables maintained by AWS and its services that
     * provide details about the context of an API query request, and can be
     * evaluated by using the <code>Condition</code> element of an IAM
     * policy. To get the list of context keys required by the policies to
     * simulate them correctly, use GetContextKeysForCustomPolicy.
     * </p>
     * <p>
     * If the output is long, you can paginate the results using the
     * <code>MaxItems</code> and <code>Marker</code> parameters.
     * </p>
     *
     * @param simulateCustomPolicyRequest Container for the necessary
     *           parameters to execute the SimulateCustomPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         SimulateCustomPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SimulateCustomPolicyResult> simulateCustomPolicyAsync(final SimulateCustomPolicyRequest simulateCustomPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SimulateCustomPolicyResult>() {
            public SimulateCustomPolicyResult call() throws Exception {
                return simulateCustomPolicy(simulateCustomPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Simulate a set of IAM policies against a list of API actions and AWS
     * resources to determine the policies' effective permissions. The
     * policies are provided as a list of strings.
     * </p>
     * <p>
     * The simulation does not perform the API actions, it only checks the
     * authorization to determine if the simulated policies allow or deny the
     * actions.
     * </p>
     * <p>
     * If you want to simulate existing policies attached to an IAM user,
     * group, or role, use SimulatePrincipalPolicy instead.
     * </p>
     * <p>
     * Context keys are variables maintained by AWS and its services that
     * provide details about the context of an API query request, and can be
     * evaluated by using the <code>Condition</code> element of an IAM
     * policy. To get the list of context keys required by the policies to
     * simulate them correctly, use GetContextKeysForCustomPolicy.
     * </p>
     * <p>
     * If the output is long, you can paginate the results using the
     * <code>MaxItems</code> and <code>Marker</code> parameters.
     * </p>
     *
     * @param simulateCustomPolicyRequest Container for the necessary
     *           parameters to execute the SimulateCustomPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SimulateCustomPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SimulateCustomPolicyResult> simulateCustomPolicyAsync(
            final SimulateCustomPolicyRequest simulateCustomPolicyRequest,
            final AsyncHandler<SimulateCustomPolicyRequest, SimulateCustomPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SimulateCustomPolicyResult>() {
            public SimulateCustomPolicyResult call() throws Exception {
              SimulateCustomPolicyResult result;
                try {
                result = simulateCustomPolicy(simulateCustomPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(simulateCustomPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified role. The role must not have any policies
     * attached. For more information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a>
     * .
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Make sure you do not have any Amazon EC2 instances
     * running with the role you are about to delete. Deleting a role or
     * instance profile that is associated with a running instance will break
     * any applications running on the instance.
     * </p>
     *
     * @param deleteRoleRequest Container for the necessary parameters to
     *           execute the DeleteRole operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteRole service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteRoleAsync(final DeleteRoleRequest deleteRoleRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteRole(deleteRoleRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified role. The role must not have any policies
     * attached. For more information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a>
     * .
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Make sure you do not have any Amazon EC2 instances
     * running with the role you are about to delete. Deleting a role or
     * instance profile that is associated with a running instance will break
     * any applications running on the instance.
     * </p>
     *
     * @param deleteRoleRequest Container for the necessary parameters to
     *           execute the DeleteRole operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteRole service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteRoleAsync(
            final DeleteRoleRequest deleteRoleRequest,
            final AsyncHandler<DeleteRoleRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteRole(deleteRoleRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteRoleRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new AWS secret access key and corresponding AWS access key
     * ID for the specified user. The default status for new keys is
     * <code>Active</code> .
     * </p>
     * <p>
     * If you do not specify a user name, IAM determines the user name
     * implicitly based on the AWS access key ID signing the request. Because
     * this action works for access keys under the AWS account, you can use
     * this action to manage root credentials even if the AWS account has no
     * associated users.
     * </p>
     * <p>
     * For information about limits on the number of keys you can create,
     * see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>IMPORTANT:</b> To ensure the security of your AWS account, the
     * secret access key is accessible only during key and user creation. You
     * must save the key (for example, in a text file) if you want to be able
     * to access it again. If a secret key is lost, you can delete the access
     * keys for the associated user and then create new keys.
     * </p>
     *
     * @param createAccessKeyRequest Container for the necessary parameters
     *           to execute the CreateAccessKey operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateAccessKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateAccessKeyResult> createAccessKeyAsync(final CreateAccessKeyRequest createAccessKeyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateAccessKeyResult>() {
            public CreateAccessKeyResult call() throws Exception {
                return createAccessKey(createAccessKeyRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a new AWS secret access key and corresponding AWS access key
     * ID for the specified user. The default status for new keys is
     * <code>Active</code> .
     * </p>
     * <p>
     * If you do not specify a user name, IAM determines the user name
     * implicitly based on the AWS access key ID signing the request. Because
     * this action works for access keys under the AWS account, you can use
     * this action to manage root credentials even if the AWS account has no
     * associated users.
     * </p>
     * <p>
     * For information about limits on the number of keys you can create,
     * see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>IMPORTANT:</b> To ensure the security of your AWS account, the
     * secret access key is accessible only during key and user creation. You
     * must save the key (for example, in a text file) if you want to be able
     * to access it again. If a secret key is lost, you can delete the access
     * keys for the associated user and then create new keys.
     * </p>
     *
     * @param createAccessKeyRequest Container for the necessary parameters
     *           to execute the CreateAccessKey operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateAccessKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateAccessKeyResult> createAccessKeyAsync(
            final CreateAccessKeyRequest createAccessKeyRequest,
            final AsyncHandler<CreateAccessKeyRequest, CreateAccessKeyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateAccessKeyResult>() {
            public CreateAccessKeyResult call() throws Exception {
              CreateAccessKeyResult result;
                try {
                result = createAccessKey(createAccessKeyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createAccessKeyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about the specified user, including the user's
     * creation date, path, unique ID, and ARN.
     * </p>
     * <p>
     * If you do not specify a user name, IAM determines the user name
     * implicitly based on the AWS access key ID used to sign the request.
     * </p>
     *
     * @param getUserRequest Container for the necessary parameters to
     *           execute the GetUser operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the GetUser
     *         service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetUserResult> getUserAsync(final GetUserRequest getUserRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetUserResult>() {
            public GetUserResult call() throws Exception {
                return getUser(getUserRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about the specified user, including the user's
     * creation date, path, unique ID, and ARN.
     * </p>
     * <p>
     * If you do not specify a user name, IAM determines the user name
     * implicitly based on the AWS access key ID used to sign the request.
     * </p>
     *
     * @param getUserRequest Container for the necessary parameters to
     *           execute the GetUser operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the GetUser
     *         service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetUserResult> getUserAsync(
            final GetUserRequest getUserRequest,
            final AsyncHandler<GetUserRequest, GetUserResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetUserResult>() {
            public GetUserResult call() throws Exception {
              GetUserResult result;
                try {
                result = getUser(getUserRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getUserRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists all managed policies that are attached to the specified group.
     * </p>
     * <p>
     * A group can also have inline policies embedded with it. To list the
     * inline policies for a group, use the ListGroupPolicies API. For
     * information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. You can use the
     * <code>PathPrefix</code> parameter to limit the list of policies to
     * only those matching the specified path prefix. If there are no
     * policies attached to the specified group (or none that match the
     * specified path prefix), the action returns an empty list.
     * </p>
     *
     * @param listAttachedGroupPoliciesRequest Container for the necessary
     *           parameters to execute the ListAttachedGroupPolicies operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListAttachedGroupPolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAttachedGroupPoliciesResult> listAttachedGroupPoliciesAsync(final ListAttachedGroupPoliciesRequest listAttachedGroupPoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAttachedGroupPoliciesResult>() {
            public ListAttachedGroupPoliciesResult call() throws Exception {
                return listAttachedGroupPolicies(listAttachedGroupPoliciesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists all managed policies that are attached to the specified group.
     * </p>
     * <p>
     * A group can also have inline policies embedded with it. To list the
     * inline policies for a group, use the ListGroupPolicies API. For
     * information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. You can use the
     * <code>PathPrefix</code> parameter to limit the list of policies to
     * only those matching the specified path prefix. If there are no
     * policies attached to the specified group (or none that match the
     * specified path prefix), the action returns an empty list.
     * </p>
     *
     * @param listAttachedGroupPoliciesRequest Container for the necessary
     *           parameters to execute the ListAttachedGroupPolicies operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListAttachedGroupPolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAttachedGroupPoliciesResult> listAttachedGroupPoliciesAsync(
            final ListAttachedGroupPoliciesRequest listAttachedGroupPoliciesRequest,
            final AsyncHandler<ListAttachedGroupPoliciesRequest, ListAttachedGroupPoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAttachedGroupPoliciesResult>() {
            public ListAttachedGroupPoliciesResult call() throws Exception {
              ListAttachedGroupPoliciesResult result;
                try {
                result = listAttachedGroupPolicies(listAttachedGroupPoliciesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listAttachedGroupPoliciesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Synchronizes the specified MFA device with AWS servers.
     * </p>
     * <p>
     * For more information about creating and working with virtual MFA
     * devices, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_VirtualMFA.html"> Using a Virtual MFA Device </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     *
     * @param resyncMFADeviceRequest Container for the necessary parameters
     *           to execute the ResyncMFADevice operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ResyncMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> resyncMFADeviceAsync(final ResyncMFADeviceRequest resyncMFADeviceRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                resyncMFADevice(resyncMFADeviceRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Synchronizes the specified MFA device with AWS servers.
     * </p>
     * <p>
     * For more information about creating and working with virtual MFA
     * devices, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_VirtualMFA.html"> Using a Virtual MFA Device </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     *
     * @param resyncMFADeviceRequest Container for the necessary parameters
     *           to execute the ResyncMFADevice operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ResyncMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> resyncMFADeviceAsync(
            final ResyncMFADeviceRequest resyncMFADeviceRequest,
            final AsyncHandler<ResyncMFADeviceRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                resyncMFADevice(resyncMFADeviceRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(resyncMFADeviceRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists the MFA devices. If the request includes the user name, then
     * this action lists all the MFA devices associated with the specified
     * user name. If you do not specify a user name, IAM determines the user
     * name implicitly based on the AWS access key ID signing the request.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listMFADevicesRequest Container for the necessary parameters to
     *           execute the ListMFADevices operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListMFADevices service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListMFADevicesResult> listMFADevicesAsync(final ListMFADevicesRequest listMFADevicesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListMFADevicesResult>() {
            public ListMFADevicesResult call() throws Exception {
                return listMFADevices(listMFADevicesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the MFA devices. If the request includes the user name, then
     * this action lists all the MFA devices associated with the specified
     * user name. If you do not specify a user name, IAM determines the user
     * name implicitly based on the AWS access key ID signing the request.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listMFADevicesRequest Container for the necessary parameters to
     *           execute the ListMFADevices operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListMFADevices service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListMFADevicesResult> listMFADevicesAsync(
            final ListMFADevicesRequest listMFADevicesRequest,
            final AsyncHandler<ListMFADevicesRequest, ListMFADevicesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListMFADevicesResult>() {
            public ListMFADevicesResult call() throws Exception {
              ListMFADevicesResult result;
                try {
                result = listMFADevices(listMFADevicesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listMFADevicesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new virtual MFA device for the AWS account. After creating
     * the virtual MFA, use EnableMFADevice to attach the MFA device to an
     * IAM user. For more information about creating and working with virtual
     * MFA devices, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_VirtualMFA.html"> Using a Virtual MFA Device </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     * <p>
     * For information about limits on the number of MFA devices you can
     * create, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on Entities </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>The seed information contained in the QR code and
     * the Base32 string should be treated like any other secret access
     * information, such as your AWS access keys or your passwords. After you
     * provision your virtual device, you should ensure that the information
     * is destroyed following secure procedures.
     * </p>
     *
     * @param createVirtualMFADeviceRequest Container for the necessary
     *           parameters to execute the CreateVirtualMFADevice operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateVirtualMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateVirtualMFADeviceResult> createVirtualMFADeviceAsync(final CreateVirtualMFADeviceRequest createVirtualMFADeviceRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateVirtualMFADeviceResult>() {
            public CreateVirtualMFADeviceResult call() throws Exception {
                return createVirtualMFADevice(createVirtualMFADeviceRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a new virtual MFA device for the AWS account. After creating
     * the virtual MFA, use EnableMFADevice to attach the MFA device to an
     * IAM user. For more information about creating and working with virtual
     * MFA devices, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_VirtualMFA.html"> Using a Virtual MFA Device </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     * <p>
     * For information about limits on the number of MFA devices you can
     * create, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on Entities </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>The seed information contained in the QR code and
     * the Base32 string should be treated like any other secret access
     * information, such as your AWS access keys or your passwords. After you
     * provision your virtual device, you should ensure that the information
     * is destroyed following secure procedures.
     * </p>
     *
     * @param createVirtualMFADeviceRequest Container for the necessary
     *           parameters to execute the CreateVirtualMFADevice operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateVirtualMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateVirtualMFADeviceResult> createVirtualMFADeviceAsync(
            final CreateVirtualMFADeviceRequest createVirtualMFADeviceRequest,
            final AsyncHandler<CreateVirtualMFADeviceRequest, CreateVirtualMFADeviceResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateVirtualMFADeviceResult>() {
            public CreateVirtualMFADeviceResult call() throws Exception {
              CreateVirtualMFADeviceResult result;
                try {
                result = createVirtualMFADevice(createVirtualMFADeviceRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createVirtualMFADeviceRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified version of the specified managed policy.
     * </p>
     * <p>
     * You cannot delete the default version of a policy using this API. To
     * delete the default version of a policy, use DeletePolicy. To find out
     * which version of a policy is marked as the default version, use
     * ListPolicyVersions.
     * </p>
     * <p>
     * For information about versions for managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-versions.html"> Versioning for Managed Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deletePolicyVersionRequest Container for the necessary
     *           parameters to execute the DeletePolicyVersion operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeletePolicyVersion service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deletePolicyVersionAsync(final DeletePolicyVersionRequest deletePolicyVersionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deletePolicyVersion(deletePolicyVersionRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified version of the specified managed policy.
     * </p>
     * <p>
     * You cannot delete the default version of a policy using this API. To
     * delete the default version of a policy, use DeletePolicy. To find out
     * which version of a policy is marked as the default version, use
     * ListPolicyVersions.
     * </p>
     * <p>
     * For information about versions for managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-versions.html"> Versioning for Managed Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deletePolicyVersionRequest Container for the necessary
     *           parameters to execute the DeletePolicyVersion operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeletePolicyVersion service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deletePolicyVersionAsync(
            final DeletePolicyVersionRequest deletePolicyVersionRequest,
            final AsyncHandler<DeletePolicyVersionRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deletePolicyVersion(deletePolicyVersionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deletePolicyVersionRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists the account aliases associated with the account. For
     * information about using an AWS account alias, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html"> Using an Alias for Your AWS Account ID </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listAccountAliasesRequest Container for the necessary
     *           parameters to execute the ListAccountAliases operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListAccountAliases service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAccountAliasesResult> listAccountAliasesAsync(final ListAccountAliasesRequest listAccountAliasesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAccountAliasesResult>() {
            public ListAccountAliasesResult call() throws Exception {
                return listAccountAliases(listAccountAliasesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the account aliases associated with the account. For
     * information about using an AWS account alias, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html"> Using an Alias for Your AWS Account ID </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listAccountAliasesRequest Container for the necessary
     *           parameters to execute the ListAccountAliases operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListAccountAliases service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAccountAliasesResult> listAccountAliasesAsync(
            final ListAccountAliasesRequest listAccountAliasesRequest,
            final AsyncHandler<ListAccountAliasesRequest, ListAccountAliasesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAccountAliasesResult>() {
            public ListAccountAliasesResult call() throws Exception {
              ListAccountAliasesResult result;
                try {
                result = listAccountAliases(listAccountAliasesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listAccountAliasesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates an IAM entity to describe an identity provider (IdP) that
     * supports
     * <a href="http://openid.net/connect/"> OpenID Connect (OIDC) </a>
     * .
     * </p>
     * <p>
     * The OIDC provider that you create with this operation can be used as
     * a principal in a role's trust policy to establish a trust relationship
     * between AWS and the OIDC provider.
     * </p>
     * <p>
     * When you create the IAM OIDC provider, you specify the URL of the
     * OIDC identity provider (IdP) to trust, a list of client IDs (also
     * known as audiences) that identify the application or applications that
     * are allowed to authenticate using the OIDC provider, and a list of
     * thumbprints of the server certificate(s) that the IdP uses. You get
     * all of this information from the OIDC IdP that you want to use for
     * access to AWS.
     * </p>
     * <p>
     * <b>NOTE:</b>Because trust for the OIDC provider is ultimately derived
     * from the IAM provider that this action creates, it is a best practice
     * to limit access to the CreateOpenIDConnectProvider action to
     * highly-privileged users.
     * </p>
     *
     * @param createOpenIDConnectProviderRequest Container for the necessary
     *           parameters to execute the CreateOpenIDConnectProvider operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateOpenIDConnectProviderResult> createOpenIDConnectProviderAsync(final CreateOpenIDConnectProviderRequest createOpenIDConnectProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateOpenIDConnectProviderResult>() {
            public CreateOpenIDConnectProviderResult call() throws Exception {
                return createOpenIDConnectProvider(createOpenIDConnectProviderRequest);
        }
    });
    }

    /**
     * <p>
     * Creates an IAM entity to describe an identity provider (IdP) that
     * supports
     * <a href="http://openid.net/connect/"> OpenID Connect (OIDC) </a>
     * .
     * </p>
     * <p>
     * The OIDC provider that you create with this operation can be used as
     * a principal in a role's trust policy to establish a trust relationship
     * between AWS and the OIDC provider.
     * </p>
     * <p>
     * When you create the IAM OIDC provider, you specify the URL of the
     * OIDC identity provider (IdP) to trust, a list of client IDs (also
     * known as audiences) that identify the application or applications that
     * are allowed to authenticate using the OIDC provider, and a list of
     * thumbprints of the server certificate(s) that the IdP uses. You get
     * all of this information from the OIDC IdP that you want to use for
     * access to AWS.
     * </p>
     * <p>
     * <b>NOTE:</b>Because trust for the OIDC provider is ultimately derived
     * from the IAM provider that this action creates, it is a best practice
     * to limit access to the CreateOpenIDConnectProvider action to
     * highly-privileged users.
     * </p>
     *
     * @param createOpenIDConnectProviderRequest Container for the necessary
     *           parameters to execute the CreateOpenIDConnectProvider operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateOpenIDConnectProviderResult> createOpenIDConnectProviderAsync(
            final CreateOpenIDConnectProviderRequest createOpenIDConnectProviderRequest,
            final AsyncHandler<CreateOpenIDConnectProviderRequest, CreateOpenIDConnectProviderResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateOpenIDConnectProviderResult>() {
            public CreateOpenIDConnectProviderResult call() throws Exception {
              CreateOpenIDConnectProviderResult result;
                try {
                result = createOpenIDConnectProvider(createOpenIDConnectProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createOpenIDConnectProviderRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about the specified role, including the role's
     * path, GUID, ARN, and the policy granting permission to assume the
     * role. For more information about ARNs, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html#Identifiers_ARNs"> ARNs </a> . For more information about roles, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a>
     * .
     * </p>
     *
     * @param getRoleRequest Container for the necessary parameters to
     *           execute the GetRole operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the GetRole
     *         service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetRoleResult> getRoleAsync(final GetRoleRequest getRoleRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetRoleResult>() {
            public GetRoleResult call() throws Exception {
                return getRole(getRoleRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about the specified role, including the role's
     * path, GUID, ARN, and the policy granting permission to assume the
     * role. For more information about ARNs, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html#Identifiers_ARNs"> ARNs </a> . For more information about roles, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a>
     * .
     * </p>
     *
     * @param getRoleRequest Container for the necessary parameters to
     *           execute the GetRole operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the GetRole
     *         service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetRoleResult> getRoleAsync(
            final GetRoleRequest getRoleRequest,
            final AsyncHandler<GetRoleRequest, GetRoleResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetRoleResult>() {
            public GetRoleResult call() throws Exception {
              GetRoleResult result;
                try {
                result = getRole(getRoleRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getRoleRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists the names of the inline policies that are embedded in the
     * specified role.
     * </p>
     * <p>
     * A role can also have managed policies attached to it. To list the
     * managed policies that are attached to a role, use
     * ListAttachedRolePolicies. For more information about policies, refer
     * to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. If there are no inline policies
     * embedded with the specified role, the action returns an empty list.
     * </p>
     *
     * @param listRolePoliciesRequest Container for the necessary parameters
     *           to execute the ListRolePolicies operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListRolePolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListRolePoliciesResult> listRolePoliciesAsync(final ListRolePoliciesRequest listRolePoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListRolePoliciesResult>() {
            public ListRolePoliciesResult call() throws Exception {
                return listRolePolicies(listRolePoliciesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the names of the inline policies that are embedded in the
     * specified role.
     * </p>
     * <p>
     * A role can also have managed policies attached to it. To list the
     * managed policies that are attached to a role, use
     * ListAttachedRolePolicies. For more information about policies, refer
     * to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. If there are no inline policies
     * embedded with the specified role, the action returns an empty list.
     * </p>
     *
     * @param listRolePoliciesRequest Container for the necessary parameters
     *           to execute the ListRolePolicies operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListRolePolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListRolePoliciesResult> listRolePoliciesAsync(
            final ListRolePoliciesRequest listRolePoliciesRequest,
            final AsyncHandler<ListRolePoliciesRequest, ListRolePoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListRolePoliciesResult>() {
            public ListRolePoliciesResult call() throws Exception {
              ListRolePoliciesResult result;
                try {
                result = listRolePolicies(listRolePoliciesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listRolePoliciesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Returns information about the signing certificates associated with
     * the specified user. If there are none, the action returns an empty
     * list.
     * </p>
     * <p>
     * Although each user is limited to a small number of signing
     * certificates, you can still paginate the results using the
     * <code>MaxItems</code> and <code>Marker</code> parameters.
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the user name is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     *
     * @param listSigningCertificatesRequest Container for the necessary
     *           parameters to execute the ListSigningCertificates operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListSigningCertificates service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListSigningCertificatesResult> listSigningCertificatesAsync(final ListSigningCertificatesRequest listSigningCertificatesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSigningCertificatesResult>() {
            public ListSigningCertificatesResult call() throws Exception {
                return listSigningCertificates(listSigningCertificatesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns information about the signing certificates associated with
     * the specified user. If there are none, the action returns an empty
     * list.
     * </p>
     * <p>
     * Although each user is limited to a small number of signing
     * certificates, you can still paginate the results using the
     * <code>MaxItems</code> and <code>Marker</code> parameters.
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the user name is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     *
     * @param listSigningCertificatesRequest Container for the necessary
     *           parameters to execute the ListSigningCertificates operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListSigningCertificates service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListSigningCertificatesResult> listSigningCertificatesAsync(
            final ListSigningCertificatesRequest listSigningCertificatesRequest,
            final AsyncHandler<ListSigningCertificatesRequest, ListSigningCertificatesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSigningCertificatesResult>() {
            public ListSigningCertificatesResult call() throws Exception {
              ListSigningCertificatesResult result;
                try {
                result = listSigningCertificates(listSigningCertificatesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listSigningCertificatesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Uploads an X.509 signing certificate and associates it with the
     * specified user. Some AWS services use X.509 signing certificates to
     * validate requests that are signed with a corresponding private key.
     * When you upload the certificate, its default status is
     * <code>Active</code> .
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the user name is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     * <p>
     * <b>NOTE:</b>Because the body of a X.509 certificate can be large, you
     * should use POST rather than GET when calling UploadSigningCertificate.
     * For information about setting up signatures and authorization through
     * the API, go to Signing AWS API Requests in the AWS General Reference.
     * For general information about using the Query API with IAM, go to
     * Making Query Requests in the Using IAMguide.
     * </p>
     *
     * @param uploadSigningCertificateRequest Container for the necessary
     *           parameters to execute the UploadSigningCertificate operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UploadSigningCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<UploadSigningCertificateResult> uploadSigningCertificateAsync(final UploadSigningCertificateRequest uploadSigningCertificateRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UploadSigningCertificateResult>() {
            public UploadSigningCertificateResult call() throws Exception {
                return uploadSigningCertificate(uploadSigningCertificateRequest);
        }
    });
    }

    /**
     * <p>
     * Uploads an X.509 signing certificate and associates it with the
     * specified user. Some AWS services use X.509 signing certificates to
     * validate requests that are signed with a corresponding private key.
     * When you upload the certificate, its default status is
     * <code>Active</code> .
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the user name is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     * <p>
     * <b>NOTE:</b>Because the body of a X.509 certificate can be large, you
     * should use POST rather than GET when calling UploadSigningCertificate.
     * For information about setting up signatures and authorization through
     * the API, go to Signing AWS API Requests in the AWS General Reference.
     * For general information about using the Query API with IAM, go to
     * Making Query Requests in the Using IAMguide.
     * </p>
     *
     * @param uploadSigningCertificateRequest Container for the necessary
     *           parameters to execute the UploadSigningCertificate operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UploadSigningCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<UploadSigningCertificateResult> uploadSigningCertificateAsync(
            final UploadSigningCertificateRequest uploadSigningCertificateRequest,
            final AsyncHandler<UploadSigningCertificateRequest, UploadSigningCertificateResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UploadSigningCertificateResult>() {
            public UploadSigningCertificateResult call() throws Exception {
              UploadSigningCertificateResult result;
                try {
                result = uploadSigningCertificate(uploadSigningCertificateRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(uploadSigningCertificateRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about all IAM users, groups, roles, and
     * policies in your account, including their relationships to one
     * another. Use this API to obtain a snapshot of the configuration of IAM
     * permissions (users, groups, roles, and policies) in your account.
     * </p>
     * <p>
     * You can optionally filter the results using the <code>Filter</code>
     * parameter. You can paginate the results using the
     * <code>MaxItems</code> and <code>Marker</code> parameters.
     * </p>
     *
     * @param getAccountAuthorizationDetailsRequest Container for the
     *           necessary parameters to execute the GetAccountAuthorizationDetails
     *           operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetAccountAuthorizationDetails service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(final GetAccountAuthorizationDetailsRequest getAccountAuthorizationDetailsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAccountAuthorizationDetailsResult>() {
            public GetAccountAuthorizationDetailsResult call() throws Exception {
                return getAccountAuthorizationDetails(getAccountAuthorizationDetailsRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about all IAM users, groups, roles, and
     * policies in your account, including their relationships to one
     * another. Use this API to obtain a snapshot of the configuration of IAM
     * permissions (users, groups, roles, and policies) in your account.
     * </p>
     * <p>
     * You can optionally filter the results using the <code>Filter</code>
     * parameter. You can paginate the results using the
     * <code>MaxItems</code> and <code>Marker</code> parameters.
     * </p>
     *
     * @param getAccountAuthorizationDetailsRequest Container for the
     *           necessary parameters to execute the GetAccountAuthorizationDetails
     *           operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetAccountAuthorizationDetails service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(
            final GetAccountAuthorizationDetailsRequest getAccountAuthorizationDetailsRequest,
            final AsyncHandler<GetAccountAuthorizationDetailsRequest, GetAccountAuthorizationDetailsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAccountAuthorizationDetailsResult>() {
            public GetAccountAuthorizationDetailsResult call() throws Exception {
              GetAccountAuthorizationDetailsResult result;
                try {
                result = getAccountAuthorizationDetails(getAccountAuthorizationDetailsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getAccountAuthorizationDetailsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Changes the password of the IAM user who is calling this action. The
     * root account password is not affected by this action.
     * </p>
     * <p>
     * To change the password for a different user, see UpdateLoginProfile.
     * For more information about modifying passwords, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingLogins.html"> Managing Passwords </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param changePasswordRequest Container for the necessary parameters to
     *           execute the ChangePassword operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ChangePassword service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> changePasswordAsync(final ChangePasswordRequest changePasswordRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                changePassword(changePasswordRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Changes the password of the IAM user who is calling this action. The
     * root account password is not affected by this action.
     * </p>
     * <p>
     * To change the password for a different user, see UpdateLoginProfile.
     * For more information about modifying passwords, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingLogins.html"> Managing Passwords </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param changePasswordRequest Container for the necessary parameters to
     *           execute the ChangePassword operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ChangePassword service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> changePasswordAsync(
            final ChangePasswordRequest changePasswordRequest,
            final AsyncHandler<ChangePasswordRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                changePassword(changePasswordRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(changePasswordRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Adds (or updates) an inline policy document that is embedded in the
     * specified group.
     * </p>
     * <p>
     * A user can also have managed policies attached to it. To attach a
     * managed policy to a group, use AttachGroupPolicy. To create a new
     * managed policy, use CreatePolicy. For information about policies,
     * refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For information about limits on the number of inline policies that
     * you can embed in a group, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b>Because policy documents can be large, you should use
     * POST rather than GET when calling PutGroupPolicy. For general
     * information about using the Query API with IAM, go to Making Query
     * Requests in the Using IAM guide.
     * </p>
     *
     * @param putGroupPolicyRequest Container for the necessary parameters to
     *           execute the PutGroupPolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         PutGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putGroupPolicyAsync(final PutGroupPolicyRequest putGroupPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                putGroupPolicy(putGroupPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Adds (or updates) an inline policy document that is embedded in the
     * specified group.
     * </p>
     * <p>
     * A user can also have managed policies attached to it. To attach a
     * managed policy to a group, use AttachGroupPolicy. To create a new
     * managed policy, use CreatePolicy. For information about policies,
     * refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For information about limits on the number of inline policies that
     * you can embed in a group, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b>Because policy documents can be large, you should use
     * POST rather than GET when calling PutGroupPolicy. For general
     * information about using the Query API with IAM, go to Making Query
     * Requests in the Using IAM guide.
     * </p>
     *
     * @param putGroupPolicyRequest Container for the necessary parameters to
     *           execute the PutGroupPolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         PutGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putGroupPolicyAsync(
            final PutGroupPolicyRequest putGroupPolicyRequest,
            final AsyncHandler<PutGroupPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                putGroupPolicy(putGroupPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(putGroupPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified signing certificate associated with the
     * specified user.
     * </p>
     * <p>
     * If you do not specify a user name, IAM determines the user name
     * implicitly based on the AWS access key ID signing the request. Because
     * this action works for access keys under the AWS account, you can use
     * this action to manage root credentials even if the AWS account has no
     * associated users.
     * </p>
     *
     * @param deleteSigningCertificateRequest Container for the necessary
     *           parameters to execute the DeleteSigningCertificate operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteSigningCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteSigningCertificateAsync(final DeleteSigningCertificateRequest deleteSigningCertificateRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteSigningCertificate(deleteSigningCertificateRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified signing certificate associated with the
     * specified user.
     * </p>
     * <p>
     * If you do not specify a user name, IAM determines the user name
     * implicitly based on the AWS access key ID signing the request. Because
     * this action works for access keys under the AWS account, you can use
     * this action to manage root credentials even if the AWS account has no
     * associated users.
     * </p>
     *
     * @param deleteSigningCertificateRequest Container for the necessary
     *           parameters to execute the DeleteSigningCertificate operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteSigningCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteSigningCertificateAsync(
            final DeleteSigningCertificateRequest deleteSigningCertificateRequest,
            final AsyncHandler<DeleteSigningCertificateRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteSigningCertificate(deleteSigningCertificateRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteSigningCertificateRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns information about the access key IDs associated with the
     * specified user. If there are none, the action returns an empty list.
     * </p>
     * <p>
     * Although each user is limited to a small number of keys, you can
     * still paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the UserName is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     * <p>
     * <b>NOTE:</b>To ensure the security of your AWS account, the secret
     * access key is accessible only during key and user creation.
     * </p>
     *
     * @param listAccessKeysRequest Container for the necessary parameters to
     *           execute the ListAccessKeys operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListAccessKeys service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAccessKeysResult> listAccessKeysAsync(final ListAccessKeysRequest listAccessKeysRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAccessKeysResult>() {
            public ListAccessKeysResult call() throws Exception {
                return listAccessKeys(listAccessKeysRequest);
        }
    });
    }

    /**
     * <p>
     * Returns information about the access key IDs associated with the
     * specified user. If there are none, the action returns an empty list.
     * </p>
     * <p>
     * Although each user is limited to a small number of keys, you can
     * still paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the UserName is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     * <p>
     * <b>NOTE:</b>To ensure the security of your AWS account, the secret
     * access key is accessible only during key and user creation.
     * </p>
     *
     * @param listAccessKeysRequest Container for the necessary parameters to
     *           execute the ListAccessKeys operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListAccessKeys service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAccessKeysResult> listAccessKeysAsync(
            final ListAccessKeysRequest listAccessKeysRequest,
            final AsyncHandler<ListAccessKeysRequest, ListAccessKeysResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAccessKeysResult>() {
            public ListAccessKeysResult call() throws Exception {
              ListAccessKeysResult result;
                try {
                result = listAccessKeys(listAccessKeysRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listAccessKeysRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists information about the OpenID Connect providers in the AWS
     * account.
     * </p>
     *
     * @param listOpenIDConnectProvidersRequest Container for the necessary
     *           parameters to execute the ListOpenIDConnectProviders operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListOpenIDConnectProviders service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(final ListOpenIDConnectProvidersRequest listOpenIDConnectProvidersRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListOpenIDConnectProvidersResult>() {
            public ListOpenIDConnectProvidersResult call() throws Exception {
                return listOpenIDConnectProviders(listOpenIDConnectProvidersRequest);
        }
    });
    }

    /**
     * <p>
     * Lists information about the OpenID Connect providers in the AWS
     * account.
     * </p>
     *
     * @param listOpenIDConnectProvidersRequest Container for the necessary
     *           parameters to execute the ListOpenIDConnectProviders operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListOpenIDConnectProviders service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(
            final ListOpenIDConnectProvidersRequest listOpenIDConnectProvidersRequest,
            final AsyncHandler<ListOpenIDConnectProvidersRequest, ListOpenIDConnectProvidersResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListOpenIDConnectProvidersResult>() {
            public ListOpenIDConnectProvidersResult call() throws Exception {
              ListOpenIDConnectProvidersResult result;
                try {
                result = listOpenIDConnectProviders(listOpenIDConnectProvidersRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listOpenIDConnectProvidersRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Replaces the existing list of server certificate thumbprints with a
     * new list.
     * </p>
     * <p>
     * The list that you pass with this action completely replaces the
     * existing list of thumbprints. (The lists are not merged.)
     * </p>
     * <p>
     * Typically, you need to update a thumbprint only when the identity
     * provider's certificate changes, which occurs rarely. However, if the
     * provider's certificate <i>does</i> change, any attempt to assume an
     * IAM role that specifies the OIDC provider as a principal will fail
     * until the certificate thumbprint is updated.
     * </p>
     * <p>
     * <b>NOTE:</b>Because trust for the OpenID Connect provider is
     * ultimately derived from the provider's certificate and is validated by
     * the thumbprint, it is a best practice to limit access to the
     * UpdateOpenIDConnectProviderThumbprint action to highly-privileged
     * users.
     * </p>
     *
     * @param updateOpenIDConnectProviderThumbprintRequest Container for the
     *           necessary parameters to execute the
     *           UpdateOpenIDConnectProviderThumbprint operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateOpenIDConnectProviderThumbprint service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateOpenIDConnectProviderThumbprintAsync(final UpdateOpenIDConnectProviderThumbprintRequest updateOpenIDConnectProviderThumbprintRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateOpenIDConnectProviderThumbprint(updateOpenIDConnectProviderThumbprintRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Replaces the existing list of server certificate thumbprints with a
     * new list.
     * </p>
     * <p>
     * The list that you pass with this action completely replaces the
     * existing list of thumbprints. (The lists are not merged.)
     * </p>
     * <p>
     * Typically, you need to update a thumbprint only when the identity
     * provider's certificate changes, which occurs rarely. However, if the
     * provider's certificate <i>does</i> change, any attempt to assume an
     * IAM role that specifies the OIDC provider as a principal will fail
     * until the certificate thumbprint is updated.
     * </p>
     * <p>
     * <b>NOTE:</b>Because trust for the OpenID Connect provider is
     * ultimately derived from the provider's certificate and is validated by
     * the thumbprint, it is a best practice to limit access to the
     * UpdateOpenIDConnectProviderThumbprint action to highly-privileged
     * users.
     * </p>
     *
     * @param updateOpenIDConnectProviderThumbprintRequest Container for the
     *           necessary parameters to execute the
     *           UpdateOpenIDConnectProviderThumbprint operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateOpenIDConnectProviderThumbprint service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateOpenIDConnectProviderThumbprintAsync(
            final UpdateOpenIDConnectProviderThumbprintRequest updateOpenIDConnectProviderThumbprintRequest,
            final AsyncHandler<UpdateOpenIDConnectProviderThumbprintRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateOpenIDConnectProviderThumbprint(updateOpenIDConnectProviderThumbprintRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateOpenIDConnectProviderThumbprintRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves the specified SSH public key, including metadata about the
     * key.
     * </p>
     * <p>
     * The SSH public key retrieved by this action is used only for
     * authenticating the associated IAM user to an AWS CodeCommit
     * repository. For more information about using SSH keys to authenticate
     * to an AWS CodeCommit repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     *
     * @param getSSHPublicKeyRequest Container for the necessary parameters
     *           to execute the GetSSHPublicKey operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetSSHPublicKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetSSHPublicKeyResult> getSSHPublicKeyAsync(final GetSSHPublicKeyRequest getSSHPublicKeyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetSSHPublicKeyResult>() {
            public GetSSHPublicKeyResult call() throws Exception {
                return getSSHPublicKey(getSSHPublicKeyRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves the specified SSH public key, including metadata about the
     * key.
     * </p>
     * <p>
     * The SSH public key retrieved by this action is used only for
     * authenticating the associated IAM user to an AWS CodeCommit
     * repository. For more information about using SSH keys to authenticate
     * to an AWS CodeCommit repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     *
     * @param getSSHPublicKeyRequest Container for the necessary parameters
     *           to execute the GetSSHPublicKey operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetSSHPublicKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetSSHPublicKeyResult> getSSHPublicKeyAsync(
            final GetSSHPublicKeyRequest getSSHPublicKeyRequest,
            final AsyncHandler<GetSSHPublicKeyRequest, GetSSHPublicKeyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetSSHPublicKeyResult>() {
            public GetSSHPublicKeyResult call() throws Exception {
              GetSSHPublicKeyResult result;
                try {
                result = getSSHPublicKey(getSSHPublicKeyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getSSHPublicKeyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Removes the specified managed policy from the specified role.
     * </p>
     * <p>
     * A role can also have inline policies embedded with it. To delete an
     * inline policy, use the DeleteRolePolicy API. For information about
     * policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param detachRolePolicyRequest Container for the necessary parameters
     *           to execute the DetachRolePolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DetachRolePolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> detachRolePolicyAsync(final DetachRolePolicyRequest detachRolePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                detachRolePolicy(detachRolePolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Removes the specified managed policy from the specified role.
     * </p>
     * <p>
     * A role can also have inline policies embedded with it. To delete an
     * inline policy, use the DeleteRolePolicy API. For information about
     * policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param detachRolePolicyRequest Container for the necessary parameters
     *           to execute the DetachRolePolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DetachRolePolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> detachRolePolicyAsync(
            final DetachRolePolicyRequest detachRolePolicyRequest,
            final AsyncHandler<DetachRolePolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                detachRolePolicy(detachRolePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(detachRolePolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new managed policy for your AWS account.
     * </p>
     * <p>
     * This operation creates a policy version with a version identifier of
     * <code>v1</code> and sets v1 as the policy's default version. For more
     * information about policy versions, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-versions.html"> Versioning for Managed Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For more information about managed policies in general, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createPolicyRequest Container for the necessary parameters to
     *           execute the CreatePolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreatePolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreatePolicyResult> createPolicyAsync(final CreatePolicyRequest createPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreatePolicyResult>() {
            public CreatePolicyResult call() throws Exception {
                return createPolicy(createPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a new managed policy for your AWS account.
     * </p>
     * <p>
     * This operation creates a policy version with a version identifier of
     * <code>v1</code> and sets v1 as the policy's default version. For more
     * information about policy versions, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-versions.html"> Versioning for Managed Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For more information about managed policies in general, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createPolicyRequest Container for the necessary parameters to
     *           execute the CreatePolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreatePolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreatePolicyResult> createPolicyAsync(
            final CreatePolicyRequest createPolicyRequest,
            final AsyncHandler<CreatePolicyRequest, CreatePolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreatePolicyResult>() {
            public CreatePolicyResult call() throws Exception {
              CreatePolicyResult result;
                try {
                result = createPolicy(createPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new instance profile. For information about instance
     * profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     * <p>
     * For information about the number of instance profiles you can create,
     * see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createInstanceProfileRequest Container for the necessary
     *           parameters to execute the CreateInstanceProfile operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateInstanceProfileResult> createInstanceProfileAsync(final CreateInstanceProfileRequest createInstanceProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateInstanceProfileResult>() {
            public CreateInstanceProfileResult call() throws Exception {
                return createInstanceProfile(createInstanceProfileRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a new instance profile. For information about instance
     * profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     * <p>
     * For information about the number of instance profiles you can create,
     * see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createInstanceProfileRequest Container for the necessary
     *           parameters to execute the CreateInstanceProfile operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateInstanceProfileResult> createInstanceProfileAsync(
            final CreateInstanceProfileRequest createInstanceProfileRequest,
            final AsyncHandler<CreateInstanceProfileRequest, CreateInstanceProfileResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateInstanceProfileResult>() {
            public CreateInstanceProfileResult call() throws Exception {
              CreateInstanceProfileResult result;
                try {
                result = createInstanceProfile(createInstanceProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createInstanceProfileRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates a password for the specified user, giving the user the
     * ability to access AWS services through the AWS Management Console. For
     * more information about managing passwords, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingLogins.html"> Managing Passwords </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     *
     * @param createLoginProfileRequest Container for the necessary
     *           parameters to execute the CreateLoginProfile operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLoginProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateLoginProfileResult> createLoginProfileAsync(final CreateLoginProfileRequest createLoginProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateLoginProfileResult>() {
            public CreateLoginProfileResult call() throws Exception {
                return createLoginProfile(createLoginProfileRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a password for the specified user, giving the user the
     * ability to access AWS services through the AWS Management Console. For
     * more information about managing passwords, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingLogins.html"> Managing Passwords </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     *
     * @param createLoginProfileRequest Container for the necessary
     *           parameters to execute the CreateLoginProfile operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLoginProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateLoginProfileResult> createLoginProfileAsync(
            final CreateLoginProfileRequest createLoginProfileRequest,
            final AsyncHandler<CreateLoginProfileRequest, CreateLoginProfileResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateLoginProfileResult>() {
            public CreateLoginProfileResult call() throws Exception {
              CreateLoginProfileResult result;
                try {
                result = createLoginProfile(createLoginProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createLoginProfileRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Removes the specified role from the specified instance profile.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Make sure you do not have any Amazon EC2 instances
     * running with the role you are about to remove from the instance
     * profile. Removing a role from an instance profile that is associated
     * with a running instance will break any applications running on the
     * instance.
     * </p>
     * <p>
     * For more information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a> . For more information about instance profiles, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     *
     * @param removeRoleFromInstanceProfileRequest Container for the
     *           necessary parameters to execute the RemoveRoleFromInstanceProfile
     *           operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         RemoveRoleFromInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> removeRoleFromInstanceProfileAsync(final RemoveRoleFromInstanceProfileRequest removeRoleFromInstanceProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                removeRoleFromInstanceProfile(removeRoleFromInstanceProfileRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Removes the specified role from the specified instance profile.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Make sure you do not have any Amazon EC2 instances
     * running with the role you are about to remove from the instance
     * profile. Removing a role from an instance profile that is associated
     * with a running instance will break any applications running on the
     * instance.
     * </p>
     * <p>
     * For more information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a> . For more information about instance profiles, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     *
     * @param removeRoleFromInstanceProfileRequest Container for the
     *           necessary parameters to execute the RemoveRoleFromInstanceProfile
     *           operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         RemoveRoleFromInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> removeRoleFromInstanceProfileAsync(
            final RemoveRoleFromInstanceProfileRequest removeRoleFromInstanceProfileRequest,
            final AsyncHandler<RemoveRoleFromInstanceProfileRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                removeRoleFromInstanceProfile(removeRoleFromInstanceProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(removeRoleFromInstanceProfileRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Updates the password policy settings for the AWS account.
     * </p>
     * <p>
     * <b>NOTE:</b> This action does not support partial updates. No
     * parameters are required, but if you do not specify a parameter, that
     * parameter's value reverts to its default value. See the Request
     * Parameters section for each parameter's default value.
     * </p>
     * <p>
     * For more information about using a password policy, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingPasswordPolicies.html"> Managing an IAM Password Policy </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param updateAccountPasswordPolicyRequest Container for the necessary
     *           parameters to execute the UpdateAccountPasswordPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateAccountPasswordPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateAccountPasswordPolicyAsync(final UpdateAccountPasswordPolicyRequest updateAccountPasswordPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateAccountPasswordPolicy(updateAccountPasswordPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Updates the password policy settings for the AWS account.
     * </p>
     * <p>
     * <b>NOTE:</b> This action does not support partial updates. No
     * parameters are required, but if you do not specify a parameter, that
     * parameter's value reverts to its default value. See the Request
     * Parameters section for each parameter's default value.
     * </p>
     * <p>
     * For more information about using a password policy, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingPasswordPolicies.html"> Managing an IAM Password Policy </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param updateAccountPasswordPolicyRequest Container for the necessary
     *           parameters to execute the UpdateAccountPasswordPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateAccountPasswordPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateAccountPasswordPolicyAsync(
            final UpdateAccountPasswordPolicyRequest updateAccountPasswordPolicyRequest,
            final AsyncHandler<UpdateAccountPasswordPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateAccountPasswordPolicy(updateAccountPasswordPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateAccountPasswordPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Updates the policy that grants an entity permission to assume a role.
     * For more information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/roles-toplevel.html"> Using Roles to Delegate Permissions and Federate Identities </a>
     * .
     * </p>
     *
     * @param updateAssumeRolePolicyRequest Container for the necessary
     *           parameters to execute the UpdateAssumeRolePolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateAssumeRolePolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateAssumeRolePolicyAsync(final UpdateAssumeRolePolicyRequest updateAssumeRolePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateAssumeRolePolicy(updateAssumeRolePolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Updates the policy that grants an entity permission to assume a role.
     * For more information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/roles-toplevel.html"> Using Roles to Delegate Permissions and Federate Identities </a>
     * .
     * </p>
     *
     * @param updateAssumeRolePolicyRequest Container for the necessary
     *           parameters to execute the UpdateAssumeRolePolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateAssumeRolePolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateAssumeRolePolicyAsync(
            final UpdateAssumeRolePolicyRequest updateAssumeRolePolicyRequest,
            final AsyncHandler<UpdateAssumeRolePolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateAssumeRolePolicy(updateAssumeRolePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateAssumeRolePolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about the specified instance profile, including
     * the instance profile's path, GUID, ARN, and role. For more information
     * about instance profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a> . For more information about ARNs, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html#Identifiers_ARNs"> ARNs </a>
     * .
     * </p>
     *
     * @param getInstanceProfileRequest Container for the necessary
     *           parameters to execute the GetInstanceProfile operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetInstanceProfileResult> getInstanceProfileAsync(final GetInstanceProfileRequest getInstanceProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetInstanceProfileResult>() {
            public GetInstanceProfileResult call() throws Exception {
                return getInstanceProfile(getInstanceProfileRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about the specified instance profile, including
     * the instance profile's path, GUID, ARN, and role. For more information
     * about instance profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a> . For more information about ARNs, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html#Identifiers_ARNs"> ARNs </a>
     * .
     * </p>
     *
     * @param getInstanceProfileRequest Container for the necessary
     *           parameters to execute the GetInstanceProfile operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetInstanceProfileResult> getInstanceProfileAsync(
            final GetInstanceProfileRequest getInstanceProfileRequest,
            final AsyncHandler<GetInstanceProfileRequest, GetInstanceProfileResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetInstanceProfileResult>() {
            public GetInstanceProfileResult call() throws Exception {
              GetInstanceProfileResult result;
                try {
                result = getInstanceProfile(getInstanceProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getInstanceProfileRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about IAM entity usage and IAM quotas in the
     * AWS account.
     * </p>
     * <p>
     * For information about limitations on IAM entities, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getAccountSummaryRequest Container for the necessary parameters
     *           to execute the GetAccountSummary operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetAccountSummary service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAccountSummaryResult> getAccountSummaryAsync(final GetAccountSummaryRequest getAccountSummaryRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAccountSummaryResult>() {
            public GetAccountSummaryResult call() throws Exception {
                return getAccountSummary(getAccountSummaryRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about IAM entity usage and IAM quotas in the
     * AWS account.
     * </p>
     * <p>
     * For information about limitations on IAM entities, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getAccountSummaryRequest Container for the necessary parameters
     *           to execute the GetAccountSummary operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetAccountSummary service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAccountSummaryResult> getAccountSummaryAsync(
            final GetAccountSummaryRequest getAccountSummaryRequest,
            final AsyncHandler<GetAccountSummaryRequest, GetAccountSummaryResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAccountSummaryResult>() {
            public GetAccountSummaryResult call() throws Exception {
              GetAccountSummaryResult result;
                try {
                result = getAccountSummary(getAccountSummaryRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getAccountSummaryRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates an IAM entity to describe an identity provider (IdP) that
     * supports SAML 2.0.
     * </p>
     * <p>
     * The SAML provider that you create with this operation can be used as
     * a principal in a role's trust policy to establish a trust relationship
     * between AWS and a SAML identity provider. You can create an IAM role
     * that supports Web-based single sign-on (SSO) to the AWS Management
     * Console or one that supports API access to AWS.
     * </p>
     * <p>
     * When you create the SAML provider, you upload an a SAML metadata
     * document that you get from your IdP and that includes the issuer's
     * name, expiration information, and keys that can be used to validate
     * the SAML authentication response (assertions) that are received from
     * the IdP. You must generate the metadata document using the identity
     * management software that is used as your organization's IdP.
     * </p>
     * <p>
     * <b>NOTE:</b> This operation requires Signature Version 4.
     * </p>
     * <p>
     * For more information, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_enable-console-saml.html"> Enabling SAML 2.0 Federated Users to Access the AWS Management Console </a> and <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_saml.html"> About SAML 2.0-based Federation </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createSAMLProviderRequest Container for the necessary
     *           parameters to execute the CreateSAMLProvider operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateSAMLProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateSAMLProviderResult> createSAMLProviderAsync(final CreateSAMLProviderRequest createSAMLProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateSAMLProviderResult>() {
            public CreateSAMLProviderResult call() throws Exception {
                return createSAMLProvider(createSAMLProviderRequest);
        }
    });
    }

    /**
     * <p>
     * Creates an IAM entity to describe an identity provider (IdP) that
     * supports SAML 2.0.
     * </p>
     * <p>
     * The SAML provider that you create with this operation can be used as
     * a principal in a role's trust policy to establish a trust relationship
     * between AWS and a SAML identity provider. You can create an IAM role
     * that supports Web-based single sign-on (SSO) to the AWS Management
     * Console or one that supports API access to AWS.
     * </p>
     * <p>
     * When you create the SAML provider, you upload an a SAML metadata
     * document that you get from your IdP and that includes the issuer's
     * name, expiration information, and keys that can be used to validate
     * the SAML authentication response (assertions) that are received from
     * the IdP. You must generate the metadata document using the identity
     * management software that is used as your organization's IdP.
     * </p>
     * <p>
     * <b>NOTE:</b> This operation requires Signature Version 4.
     * </p>
     * <p>
     * For more information, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_enable-console-saml.html"> Enabling SAML 2.0 Federated Users to Access the AWS Management Console </a> and <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_saml.html"> About SAML 2.0-based Federation </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createSAMLProviderRequest Container for the necessary
     *           parameters to execute the CreateSAMLProvider operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateSAMLProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateSAMLProviderResult> createSAMLProviderAsync(
            final CreateSAMLProviderRequest createSAMLProviderRequest,
            final AsyncHandler<CreateSAMLProviderRequest, CreateSAMLProviderResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateSAMLProviderResult>() {
            public CreateSAMLProviderResult call() throws Exception {
              CreateSAMLProviderResult result;
                try {
                result = createSAMLProvider(createSAMLProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createSAMLProviderRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about the specified managed policy, including
     * the policy's default version and the total number of users, groups,
     * and roles that the policy is attached to. For a list of the specific
     * users, groups, and roles that the policy is attached to, use the
     * ListEntitiesForPolicy API. This API returns metadata about the policy.
     * To retrieve the policy document for a specific version of the policy,
     * use GetPolicyVersion.
     * </p>
     * <p>
     * This API retrieves information about managed policies. To retrieve
     * information about an inline policy that is embedded with a user,
     * group, or role, use the GetUserPolicy, GetGroupPolicy, or
     * GetRolePolicy API.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getPolicyRequest Container for the necessary parameters to
     *           execute the GetPolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetPolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetPolicyResult> getPolicyAsync(final GetPolicyRequest getPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetPolicyResult>() {
            public GetPolicyResult call() throws Exception {
                return getPolicy(getPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about the specified managed policy, including
     * the policy's default version and the total number of users, groups,
     * and roles that the policy is attached to. For a list of the specific
     * users, groups, and roles that the policy is attached to, use the
     * ListEntitiesForPolicy API. This API returns metadata about the policy.
     * To retrieve the policy document for a specific version of the policy,
     * use GetPolicyVersion.
     * </p>
     * <p>
     * This API retrieves information about managed policies. To retrieve
     * information about an inline policy that is embedded with a user,
     * group, or role, use the GetUserPolicy, GetGroupPolicy, or
     * GetRolePolicy API.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getPolicyRequest Container for the necessary parameters to
     *           execute the GetPolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetPolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetPolicyResult> getPolicyAsync(
            final GetPolicyRequest getPolicyRequest,
            final AsyncHandler<GetPolicyRequest, GetPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetPolicyResult>() {
            public GetPolicyResult call() throws Exception {
              GetPolicyResult result;
                try {
                result = getPolicy(getPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists information about the versions of the specified managed policy,
     * including the version that is set as the policy's default version.
     * </p>
     * <p>
     * For more information about managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param listPolicyVersionsRequest Container for the necessary
     *           parameters to execute the ListPolicyVersions operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListPolicyVersions service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListPolicyVersionsResult> listPolicyVersionsAsync(final ListPolicyVersionsRequest listPolicyVersionsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPolicyVersionsResult>() {
            public ListPolicyVersionsResult call() throws Exception {
                return listPolicyVersions(listPolicyVersionsRequest);
        }
    });
    }

    /**
     * <p>
     * Lists information about the versions of the specified managed policy,
     * including the version that is set as the policy's default version.
     * </p>
     * <p>
     * For more information about managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param listPolicyVersionsRequest Container for the necessary
     *           parameters to execute the ListPolicyVersions operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListPolicyVersions service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListPolicyVersionsResult> listPolicyVersionsAsync(
            final ListPolicyVersionsRequest listPolicyVersionsRequest,
            final AsyncHandler<ListPolicyVersionsRequest, ListPolicyVersionsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPolicyVersionsResult>() {
            public ListPolicyVersionsResult call() throws Exception {
              ListPolicyVersionsResult result;
                try {
                result = listPolicyVersions(listPolicyVersionsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listPolicyVersionsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the access key associated with the specified user.
     * </p>
     * <p>
     * If you do not specify a user name, IAM determines the user name
     * implicitly based on the AWS access key ID signing the request. Because
     * this action works for access keys under the AWS account, you can use
     * this action to manage root credentials even if the AWS account has no
     * associated users.
     * </p>
     *
     * @param deleteAccessKeyRequest Container for the necessary parameters
     *           to execute the DeleteAccessKey operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAccessKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAccessKeyAsync(final DeleteAccessKeyRequest deleteAccessKeyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteAccessKey(deleteAccessKeyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the access key associated with the specified user.
     * </p>
     * <p>
     * If you do not specify a user name, IAM determines the user name
     * implicitly based on the AWS access key ID signing the request. Because
     * this action works for access keys under the AWS account, you can use
     * this action to manage root credentials even if the AWS account has no
     * associated users.
     * </p>
     *
     * @param deleteAccessKeyRequest Container for the necessary parameters
     *           to execute the DeleteAccessKey operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAccessKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAccessKeyAsync(
            final DeleteAccessKeyRequest deleteAccessKeyRequest,
            final AsyncHandler<DeleteAccessKeyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteAccessKey(deleteAccessKeyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteAccessKeyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified inline policy that is embedded in the specified
     * user.
     * </p>
     * <p>
     * A user can also have managed policies attached to it. To detach a
     * managed policy from a user, use DetachUserPolicy. For more information
     * about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deleteUserPolicyRequest Container for the necessary parameters
     *           to execute the DeleteUserPolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteUserPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteUserPolicyAsync(final DeleteUserPolicyRequest deleteUserPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteUserPolicy(deleteUserPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified inline policy that is embedded in the specified
     * user.
     * </p>
     * <p>
     * A user can also have managed policies attached to it. To detach a
     * managed policy from a user, use DetachUserPolicy. For more information
     * about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deleteUserPolicyRequest Container for the necessary parameters
     *           to execute the DeleteUserPolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteUserPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteUserPolicyAsync(
            final DeleteUserPolicyRequest deleteUserPolicyRequest,
            final AsyncHandler<DeleteUserPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteUserPolicy(deleteUserPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteUserPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists the server certificates that have the specified path prefix. If
     * none exist, the action returns an empty list.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listServerCertificatesRequest Container for the necessary
     *           parameters to execute the ListServerCertificates operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListServerCertificates service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListServerCertificatesResult> listServerCertificatesAsync(final ListServerCertificatesRequest listServerCertificatesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListServerCertificatesResult>() {
            public ListServerCertificatesResult call() throws Exception {
                return listServerCertificates(listServerCertificatesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the server certificates that have the specified path prefix. If
     * none exist, the action returns an empty list.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listServerCertificatesRequest Container for the necessary
     *           parameters to execute the ListServerCertificates operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListServerCertificates service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListServerCertificatesResult> listServerCertificatesAsync(
            final ListServerCertificatesRequest listServerCertificatesRequest,
            final AsyncHandler<ListServerCertificatesRequest, ListServerCertificatesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListServerCertificatesResult>() {
            public ListServerCertificatesResult call() throws Exception {
              ListServerCertificatesResult result;
                try {
                result = listServerCertificates(listServerCertificatesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listServerCertificatesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Updates the name and/or the path of the specified server certificate.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You should understand the implications of changing
     * a server certificate's path or name. For more information, see
     * Managing Server Certificates in the IAM User Guide.
     * </p>
     * <p>
     * <b>NOTE:</b>To change a server certificate name the requester must
     * have appropriate permissions on both the source object and the target
     * object. For example, to change the name from ProductionCert to
     * ProdCert, the entity making the request must have permission on
     * ProductionCert and ProdCert, or must have permission on all (*). For
     * more information about permissions, see Permissions and Policies.
     * </p>
     *
     * @param updateServerCertificateRequest Container for the necessary
     *           parameters to execute the UpdateServerCertificate operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateServerCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateServerCertificateAsync(final UpdateServerCertificateRequest updateServerCertificateRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateServerCertificate(updateServerCertificateRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Updates the name and/or the path of the specified server certificate.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You should understand the implications of changing
     * a server certificate's path or name. For more information, see
     * Managing Server Certificates in the IAM User Guide.
     * </p>
     * <p>
     * <b>NOTE:</b>To change a server certificate name the requester must
     * have appropriate permissions on both the source object and the target
     * object. For example, to change the name from ProductionCert to
     * ProdCert, the entity making the request must have permission on
     * ProductionCert and ProdCert, or must have permission on all (*). For
     * more information about permissions, see Permissions and Policies.
     * </p>
     *
     * @param updateServerCertificateRequest Container for the necessary
     *           parameters to execute the UpdateServerCertificate operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateServerCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateServerCertificateAsync(
            final UpdateServerCertificateRequest updateServerCertificateRequest,
            final AsyncHandler<UpdateServerCertificateRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateServerCertificate(updateServerCertificateRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateServerCertificateRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Updates the name and/or the path of the specified user.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You should understand the implications of changing
     * a user's path or name. For more information, see Renaming Users and
     * Groups in the IAM User Guide.
     * </p>
     * <p>
     * <b>NOTE:</b> To change a user name the requester must have
     * appropriate permissions on both the source object and the target
     * object. For example, to change Bob to Robert, the entity making the
     * request must have permission on Bob and Robert, or must have
     * permission on all (*). For more information about permissions, see
     * Permissions and Policies.
     * </p>
     *
     * @param updateUserRequest Container for the necessary parameters to
     *           execute the UpdateUser operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateUser service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateUserAsync(final UpdateUserRequest updateUserRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateUser(updateUserRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Updates the name and/or the path of the specified user.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You should understand the implications of changing
     * a user's path or name. For more information, see Renaming Users and
     * Groups in the IAM User Guide.
     * </p>
     * <p>
     * <b>NOTE:</b> To change a user name the requester must have
     * appropriate permissions on both the source object and the target
     * object. For example, to change Bob to Robert, the entity making the
     * request must have permission on Bob and Robert, or must have
     * permission on all (*). For more information about permissions, see
     * Permissions and Policies.
     * </p>
     *
     * @param updateUserRequest Container for the necessary parameters to
     *           execute the UpdateUser operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateUser service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateUserAsync(
            final UpdateUserRequest updateUserRequest,
            final AsyncHandler<UpdateUserRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateUser(updateUserRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateUserRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified SSH public key.
     * </p>
     * <p>
     * The SSH public key deleted by this action is used only for
     * authenticating the associated IAM user to an AWS CodeCommit
     * repository. For more information about using SSH keys to authenticate
     * to an AWS CodeCommit repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     *
     * @param deleteSSHPublicKeyRequest Container for the necessary
     *           parameters to execute the DeleteSSHPublicKey operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteSSHPublicKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteSSHPublicKeyAsync(final DeleteSSHPublicKeyRequest deleteSSHPublicKeyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteSSHPublicKey(deleteSSHPublicKeyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified SSH public key.
     * </p>
     * <p>
     * The SSH public key deleted by this action is used only for
     * authenticating the associated IAM user to an AWS CodeCommit
     * repository. For more information about using SSH keys to authenticate
     * to an AWS CodeCommit repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     *
     * @param deleteSSHPublicKeyRequest Container for the necessary
     *           parameters to execute the DeleteSSHPublicKey operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteSSHPublicKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteSSHPublicKeyAsync(
            final DeleteSSHPublicKeyRequest deleteSSHPublicKeyRequest,
            final AsyncHandler<DeleteSSHPublicKeyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteSSHPublicKey(deleteSSHPublicKeyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteSSHPublicKeyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Adds (or updates) an inline policy document that is embedded in the
     * specified role.
     * </p>
     * <p>
     * When you embed an inline policy in a role, the inline policy is used
     * as the role's access (permissions) policy. The role's trust policy is
     * created at the same time as the role, using CreateRole. You can update
     * a role's trust policy using UpdateAssumeRolePolicy. For more
     * information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/roles-toplevel.html"> Using Roles to Delegate Permissions and Federate Identities </a>
     * .
     * </p>
     * <p>
     * A role can also have a managed policy attached to it. To attach a
     * managed policy to a role, use AttachRolePolicy. To create a new
     * managed policy, use CreatePolicy. For information about policies,
     * refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For information about limits on the number of inline policies that
     * you can embed with a role, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b>Because policy documents can be large, you should use
     * POST rather than GET when calling PutRolePolicy. For general
     * information about using the Query API with IAM, go to Making Query
     * Requests in the Using IAM guide.
     * </p>
     *
     * @param putRolePolicyRequest Container for the necessary parameters to
     *           execute the PutRolePolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         PutRolePolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putRolePolicyAsync(final PutRolePolicyRequest putRolePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                putRolePolicy(putRolePolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Adds (or updates) an inline policy document that is embedded in the
     * specified role.
     * </p>
     * <p>
     * When you embed an inline policy in a role, the inline policy is used
     * as the role's access (permissions) policy. The role's trust policy is
     * created at the same time as the role, using CreateRole. You can update
     * a role's trust policy using UpdateAssumeRolePolicy. For more
     * information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/roles-toplevel.html"> Using Roles to Delegate Permissions and Federate Identities </a>
     * .
     * </p>
     * <p>
     * A role can also have a managed policy attached to it. To attach a
     * managed policy to a role, use AttachRolePolicy. To create a new
     * managed policy, use CreatePolicy. For information about policies,
     * refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For information about limits on the number of inline policies that
     * you can embed with a role, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b>Because policy documents can be large, you should use
     * POST rather than GET when calling PutRolePolicy. For general
     * information about using the Query API with IAM, go to Making Query
     * Requests in the Using IAM guide.
     * </p>
     *
     * @param putRolePolicyRequest Container for the necessary parameters to
     *           execute the PutRolePolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         PutRolePolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putRolePolicyAsync(
            final PutRolePolicyRequest putRolePolicyRequest,
            final AsyncHandler<PutRolePolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                putRolePolicy(putRolePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(putRolePolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified inline policy that is embedded in the specified
     * group.
     * </p>
     * <p>
     * A group can also have managed policies attached to it. To detach a
     * managed policy from a group, use DetachGroupPolicy. For more
     * information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deleteGroupPolicyRequest Container for the necessary parameters
     *           to execute the DeleteGroupPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteGroupPolicyAsync(final DeleteGroupPolicyRequest deleteGroupPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteGroupPolicy(deleteGroupPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified inline policy that is embedded in the specified
     * group.
     * </p>
     * <p>
     * A group can also have managed policies attached to it. To detach a
     * managed policy from a group, use DetachGroupPolicy. For more
     * information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deleteGroupPolicyRequest Container for the necessary parameters
     *           to execute the DeleteGroupPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteGroupPolicyAsync(
            final DeleteGroupPolicyRequest deleteGroupPolicyRequest,
            final AsyncHandler<DeleteGroupPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteGroupPolicy(deleteGroupPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteGroupPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Updates the name and/or the path of the specified group.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You should understand the implications of changing
     * a group's path or name. For more information, see Renaming Users and
     * Groups in the IAM User Guide.
     * </p>
     * <p>
     * <b>NOTE:</b>To change a group name the requester must have
     * appropriate permissions on both the source object and the target
     * object. For example, to change Managers to MGRs, the entity making the
     * request must have permission on Managers and MGRs, or must have
     * permission on all (*). For more information about permissions, see
     * Permissions and Policies.
     * </p>
     *
     * @param updateGroupRequest Container for the necessary parameters to
     *           execute the UpdateGroup operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateGroup service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateGroupAsync(final UpdateGroupRequest updateGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateGroup(updateGroupRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Updates the name and/or the path of the specified group.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You should understand the implications of changing
     * a group's path or name. For more information, see Renaming Users and
     * Groups in the IAM User Guide.
     * </p>
     * <p>
     * <b>NOTE:</b>To change a group name the requester must have
     * appropriate permissions on both the source object and the target
     * object. For example, to change Managers to MGRs, the entity making the
     * request must have permission on Managers and MGRs, or must have
     * permission on all (*). For more information about permissions, see
     * Permissions and Policies.
     * </p>
     *
     * @param updateGroupRequest Container for the necessary parameters to
     *           execute the UpdateGroup operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateGroup service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateGroupAsync(
            final UpdateGroupRequest updateGroupRequest,
            final AsyncHandler<UpdateGroupRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateGroup(updateGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateGroupRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Sets the status of the specified SSH public key to active or
     * inactive. SSH public keys that are inactive cannot be used for
     * authentication. This action can be used to disable a user's SSH public
     * key as part of a key rotation work flow.
     * </p>
     * <p>
     * The SSH public key affected by this action is used only for
     * authenticating the associated IAM user to an AWS CodeCommit
     * repository. For more information about using SSH keys to authenticate
     * to an AWS CodeCommit repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     *
     * @param updateSSHPublicKeyRequest Container for the necessary
     *           parameters to execute the UpdateSSHPublicKey operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateSSHPublicKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateSSHPublicKeyAsync(final UpdateSSHPublicKeyRequest updateSSHPublicKeyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateSSHPublicKey(updateSSHPublicKeyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Sets the status of the specified SSH public key to active or
     * inactive. SSH public keys that are inactive cannot be used for
     * authentication. This action can be used to disable a user's SSH public
     * key as part of a key rotation work flow.
     * </p>
     * <p>
     * The SSH public key affected by this action is used only for
     * authenticating the associated IAM user to an AWS CodeCommit
     * repository. For more information about using SSH keys to authenticate
     * to an AWS CodeCommit repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     *
     * @param updateSSHPublicKeyRequest Container for the necessary
     *           parameters to execute the UpdateSSHPublicKey operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateSSHPublicKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateSSHPublicKeyAsync(
            final UpdateSSHPublicKeyRequest updateSSHPublicKeyRequest,
            final AsyncHandler<UpdateSSHPublicKeyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateSSHPublicKey(updateSSHPublicKeyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateSSHPublicKeyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists all the managed policies that are available to your account,
     * including your own customer managed policies and all AWS managed
     * policies.
     * </p>
     * <p>
     * You can filter the list of policies that is returned using the
     * optional <code>OnlyAttached</code> , <code>Scope</code> , and
     * <code>PathPrefix</code> parameters. For example, to list only the
     * customer managed policies in your AWS account, set <code>Scope</code>
     * to <code>Local</code> . To list only AWS managed policies, set
     * <code>Scope</code> to <code>AWS</code> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     * <p>
     * For more information about managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param listPoliciesRequest Container for the necessary parameters to
     *           execute the ListPolicies operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListPolicies service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListPoliciesResult> listPoliciesAsync(final ListPoliciesRequest listPoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPoliciesResult>() {
            public ListPoliciesResult call() throws Exception {
                return listPolicies(listPoliciesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists all the managed policies that are available to your account,
     * including your own customer managed policies and all AWS managed
     * policies.
     * </p>
     * <p>
     * You can filter the list of policies that is returned using the
     * optional <code>OnlyAttached</code> , <code>Scope</code> , and
     * <code>PathPrefix</code> parameters. For example, to list only the
     * customer managed policies in your AWS account, set <code>Scope</code>
     * to <code>Local</code> . To list only AWS managed policies, set
     * <code>Scope</code> to <code>AWS</code> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     * <p>
     * For more information about managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param listPoliciesRequest Container for the necessary parameters to
     *           execute the ListPolicies operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListPolicies service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListPoliciesResult> listPoliciesAsync(
            final ListPoliciesRequest listPoliciesRequest,
            final AsyncHandler<ListPoliciesRequest, ListPoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPoliciesResult>() {
            public ListPoliciesResult call() throws Exception {
              ListPoliciesResult result;
                try {
                result = listPolicies(listPoliciesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listPoliciesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new user for your AWS account.
     * </p>
     * <p>
     * For information about limitations on the number of users you can
     * create, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createUserRequest Container for the necessary parameters to
     *           execute the CreateUser operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateUser service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateUserResult> createUserAsync(final CreateUserRequest createUserRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateUserResult>() {
            public CreateUserResult call() throws Exception {
                return createUser(createUserRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a new user for your AWS account.
     * </p>
     * <p>
     * For information about limitations on the number of users you can
     * create, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createUserRequest Container for the necessary parameters to
     *           execute the CreateUser operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateUser service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateUserResult> createUserAsync(
            final CreateUserRequest createUserRequest,
            final AsyncHandler<CreateUserRequest, CreateUserResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateUserResult>() {
            public CreateUserResult call() throws Exception {
              CreateUserResult result;
                try {
                result = createUser(createUserRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createUserRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Adds a new client ID (also known as audience) to the list of client
     * IDs already registered for the specified IAM OpenID Connect provider.
     * </p>
     * <p>
     * This action is idempotent; it does not fail or return an error if you
     * add an existing client ID to the provider.
     * </p>
     *
     * @param addClientIDToOpenIDConnectProviderRequest Container for the
     *           necessary parameters to execute the AddClientIDToOpenIDConnectProvider
     *           operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         AddClientIDToOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> addClientIDToOpenIDConnectProviderAsync(final AddClientIDToOpenIDConnectProviderRequest addClientIDToOpenIDConnectProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                addClientIDToOpenIDConnectProvider(addClientIDToOpenIDConnectProviderRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Adds a new client ID (also known as audience) to the list of client
     * IDs already registered for the specified IAM OpenID Connect provider.
     * </p>
     * <p>
     * This action is idempotent; it does not fail or return an error if you
     * add an existing client ID to the provider.
     * </p>
     *
     * @param addClientIDToOpenIDConnectProviderRequest Container for the
     *           necessary parameters to execute the AddClientIDToOpenIDConnectProvider
     *           operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         AddClientIDToOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> addClientIDToOpenIDConnectProviderAsync(
            final AddClientIDToOpenIDConnectProviderRequest addClientIDToOpenIDConnectProviderRequest,
            final AsyncHandler<AddClientIDToOpenIDConnectProviderRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                addClientIDToOpenIDConnectProvider(addClientIDToOpenIDConnectProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(addClientIDToOpenIDConnectProviderRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes a SAML provider.
     * </p>
     * <p>
     * Deleting the provider does not update any roles that reference the
     * SAML provider as a principal in their trust policies. Any attempt to
     * assume a role that references a SAML provider that has been deleted
     * will fail.
     * </p>
     * <p>
     * <b>NOTE:</b> This operation requires Signature Version 4.
     * </p>
     *
     * @param deleteSAMLProviderRequest Container for the necessary
     *           parameters to execute the DeleteSAMLProvider operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteSAMLProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteSAMLProviderAsync(final DeleteSAMLProviderRequest deleteSAMLProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteSAMLProvider(deleteSAMLProviderRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes a SAML provider.
     * </p>
     * <p>
     * Deleting the provider does not update any roles that reference the
     * SAML provider as a principal in their trust policies. Any attempt to
     * assume a role that references a SAML provider that has been deleted
     * will fail.
     * </p>
     * <p>
     * <b>NOTE:</b> This operation requires Signature Version 4.
     * </p>
     *
     * @param deleteSAMLProviderRequest Container for the necessary
     *           parameters to execute the DeleteSAMLProvider operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteSAMLProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteSAMLProviderAsync(
            final DeleteSAMLProviderRequest deleteSAMLProviderRequest,
            final AsyncHandler<DeleteSAMLProviderRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteSAMLProvider(deleteSAMLProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteSAMLProviderRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Gets a list of all of the context keys referenced in
     * <code>Condition</code> elements in all of the IAM policies attached to
     * the specified IAM entity. The entity can be an IAM user, group, or
     * role. If you specify a user, then the request also includes all of the
     * policies attached to groups that the user is a member of.
     * </p>
     * <p>
     * You can optionally include a list of one or more additional policies,
     * specified as strings. If you want to include only a list of policies
     * by string, use GetContextKeysForCustomPolicy instead.
     * </p>
     * <p>
     * <b>Note:</b> This API discloses information about the permissions
     * granted to other users. If you do not want users to see other user's
     * permissions, then consider allowing them to use
     * GetContextKeysForCustomPolicy instead.
     * </p>
     * <p>
     * Context keys are variables maintained by AWS and its services that
     * provide details about the context of an API query request, and can be
     * evaluated by using the <code>Condition</code> element of an IAM
     * policy. Use GetContextKeysForPrincipalPolicy to understand what key
     * names and values you must supply when you call
     * SimulatePrincipalPolicy.
     * </p>
     *
     * @param getContextKeysForPrincipalPolicyRequest Container for the
     *           necessary parameters to execute the GetContextKeysForPrincipalPolicy
     *           operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetContextKeysForPrincipalPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetContextKeysForPrincipalPolicyResult> getContextKeysForPrincipalPolicyAsync(final GetContextKeysForPrincipalPolicyRequest getContextKeysForPrincipalPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetContextKeysForPrincipalPolicyResult>() {
            public GetContextKeysForPrincipalPolicyResult call() throws Exception {
                return getContextKeysForPrincipalPolicy(getContextKeysForPrincipalPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Gets a list of all of the context keys referenced in
     * <code>Condition</code> elements in all of the IAM policies attached to
     * the specified IAM entity. The entity can be an IAM user, group, or
     * role. If you specify a user, then the request also includes all of the
     * policies attached to groups that the user is a member of.
     * </p>
     * <p>
     * You can optionally include a list of one or more additional policies,
     * specified as strings. If you want to include only a list of policies
     * by string, use GetContextKeysForCustomPolicy instead.
     * </p>
     * <p>
     * <b>Note:</b> This API discloses information about the permissions
     * granted to other users. If you do not want users to see other user's
     * permissions, then consider allowing them to use
     * GetContextKeysForCustomPolicy instead.
     * </p>
     * <p>
     * Context keys are variables maintained by AWS and its services that
     * provide details about the context of an API query request, and can be
     * evaluated by using the <code>Condition</code> element of an IAM
     * policy. Use GetContextKeysForPrincipalPolicy to understand what key
     * names and values you must supply when you call
     * SimulatePrincipalPolicy.
     * </p>
     *
     * @param getContextKeysForPrincipalPolicyRequest Container for the
     *           necessary parameters to execute the GetContextKeysForPrincipalPolicy
     *           operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetContextKeysForPrincipalPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetContextKeysForPrincipalPolicyResult> getContextKeysForPrincipalPolicyAsync(
            final GetContextKeysForPrincipalPolicyRequest getContextKeysForPrincipalPolicyRequest,
            final AsyncHandler<GetContextKeysForPrincipalPolicyRequest, GetContextKeysForPrincipalPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetContextKeysForPrincipalPolicyResult>() {
            public GetContextKeysForPrincipalPolicyResult call() throws Exception {
              GetContextKeysForPrincipalPolicyResult result;
                try {
                result = getContextKeysForPrincipalPolicy(getContextKeysForPrincipalPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getContextKeysForPrincipalPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Removes the specified client ID (also known as audience) from the
     * list of client IDs registered for the specified IAM OpenID Connect
     * provider.
     * </p>
     * <p>
     * This action is idempotent; it does not fail or return an error if you
     * try to remove a client ID that was removed previously.
     * </p>
     *
     * @param removeClientIDFromOpenIDConnectProviderRequest Container for
     *           the necessary parameters to execute the
     *           RemoveClientIDFromOpenIDConnectProvider operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         RemoveClientIDFromOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> removeClientIDFromOpenIDConnectProviderAsync(final RemoveClientIDFromOpenIDConnectProviderRequest removeClientIDFromOpenIDConnectProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                removeClientIDFromOpenIDConnectProvider(removeClientIDFromOpenIDConnectProviderRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Removes the specified client ID (also known as audience) from the
     * list of client IDs registered for the specified IAM OpenID Connect
     * provider.
     * </p>
     * <p>
     * This action is idempotent; it does not fail or return an error if you
     * try to remove a client ID that was removed previously.
     * </p>
     *
     * @param removeClientIDFromOpenIDConnectProviderRequest Container for
     *           the necessary parameters to execute the
     *           RemoveClientIDFromOpenIDConnectProvider operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         RemoveClientIDFromOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> removeClientIDFromOpenIDConnectProviderAsync(
            final RemoveClientIDFromOpenIDConnectProviderRequest removeClientIDFromOpenIDConnectProviderRequest,
            final AsyncHandler<RemoveClientIDFromOpenIDConnectProviderRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                removeClientIDFromOpenIDConnectProvider(removeClientIDFromOpenIDConnectProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(removeClientIDFromOpenIDConnectProviderRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new group.
     * </p>
     * <p>
     * For information about the number of groups you can create, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createGroupRequest Container for the necessary parameters to
     *           execute the CreateGroup operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateGroup service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateGroupResult> createGroupAsync(final CreateGroupRequest createGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateGroupResult>() {
            public CreateGroupResult call() throws Exception {
                return createGroup(createGroupRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a new group.
     * </p>
     * <p>
     * For information about the number of groups you can create, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createGroupRequest Container for the necessary parameters to
     *           execute the CreateGroup operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateGroup service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateGroupResult> createGroupAsync(
            final CreateGroupRequest createGroupRequest,
            final AsyncHandler<CreateGroupRequest, CreateGroupResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateGroupResult>() {
            public CreateGroupResult call() throws Exception {
              CreateGroupResult result;
                try {
                result = createGroup(createGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createGroupRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified user. The user must not belong to any groups,
     * have any keys or signing certificates, or have any attached policies.
     * </p>
     *
     * @param deleteUserRequest Container for the necessary parameters to
     *           execute the DeleteUser operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteUser service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteUserAsync(final DeleteUserRequest deleteUserRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteUser(deleteUserRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified user. The user must not belong to any groups,
     * have any keys or signing certificates, or have any attached policies.
     * </p>
     *
     * @param deleteUserRequest Container for the necessary parameters to
     *           execute the DeleteUser operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteUser service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteUserAsync(
            final DeleteUserRequest deleteUserRequest,
            final AsyncHandler<DeleteUserRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteUser(deleteUserRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteUserRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deactivates the specified MFA device and removes it from association
     * with the user name for which it was originally enabled.
     * </p>
     * <p>
     * For more information about creating and working with virtual MFA
     * devices, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_VirtualMFA.html"> Using a Virtual MFA Device </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     *
     * @param deactivateMFADeviceRequest Container for the necessary
     *           parameters to execute the DeactivateMFADevice operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeactivateMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deactivateMFADeviceAsync(final DeactivateMFADeviceRequest deactivateMFADeviceRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deactivateMFADevice(deactivateMFADeviceRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deactivates the specified MFA device and removes it from association
     * with the user name for which it was originally enabled.
     * </p>
     * <p>
     * For more information about creating and working with virtual MFA
     * devices, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_VirtualMFA.html"> Using a Virtual MFA Device </a>
     * in the <i>Using IAM</i> guide.
     * </p>
     *
     * @param deactivateMFADeviceRequest Container for the necessary
     *           parameters to execute the DeactivateMFADevice operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeactivateMFADevice service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deactivateMFADeviceAsync(
            final DeactivateMFADeviceRequest deactivateMFADeviceRequest,
            final AsyncHandler<DeactivateMFADeviceRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deactivateMFADevice(deactivateMFADeviceRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deactivateMFADeviceRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about the specified version of the specified
     * managed policy, including the policy document.
     * </p>
     * <p>
     * To list the available versions for a policy, use ListPolicyVersions.
     * </p>
     * <p>
     * This API retrieves information about managed policies. To retrieve
     * information about an inline policy that is embedded in a user, group,
     * or role, use the GetUserPolicy, GetGroupPolicy, or GetRolePolicy API.
     * </p>
     * <p>
     * For more information about the types of policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getPolicyVersionRequest Container for the necessary parameters
     *           to execute the GetPolicyVersion operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetPolicyVersion service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetPolicyVersionResult> getPolicyVersionAsync(final GetPolicyVersionRequest getPolicyVersionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetPolicyVersionResult>() {
            public GetPolicyVersionResult call() throws Exception {
                return getPolicyVersion(getPolicyVersionRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about the specified version of the specified
     * managed policy, including the policy document.
     * </p>
     * <p>
     * To list the available versions for a policy, use ListPolicyVersions.
     * </p>
     * <p>
     * This API retrieves information about managed policies. To retrieve
     * information about an inline policy that is embedded in a user, group,
     * or role, use the GetUserPolicy, GetGroupPolicy, or GetRolePolicy API.
     * </p>
     * <p>
     * For more information about the types of policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getPolicyVersionRequest Container for the necessary parameters
     *           to execute the GetPolicyVersion operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetPolicyVersion service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetPolicyVersionResult> getPolicyVersionAsync(
            final GetPolicyVersionRequest getPolicyVersionRequest,
            final AsyncHandler<GetPolicyVersionRequest, GetPolicyVersionResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetPolicyVersionResult>() {
            public GetPolicyVersionResult call() throws Exception {
              GetPolicyVersionResult result;
                try {
                result = getPolicyVersion(getPolicyVersionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getPolicyVersionRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Generates a credential report for the AWS account. For more
     * information about the credential report, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/credential-reports.html"> Getting Credential Reports </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param generateCredentialReportRequest Container for the necessary
     *           parameters to execute the GenerateCredentialReport operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GenerateCredentialReport service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GenerateCredentialReportResult> generateCredentialReportAsync(final GenerateCredentialReportRequest generateCredentialReportRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GenerateCredentialReportResult>() {
            public GenerateCredentialReportResult call() throws Exception {
                return generateCredentialReport(generateCredentialReportRequest);
        }
    });
    }

    /**
     * <p>
     * Generates a credential report for the AWS account. For more
     * information about the credential report, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/credential-reports.html"> Getting Credential Reports </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param generateCredentialReportRequest Container for the necessary
     *           parameters to execute the GenerateCredentialReport operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GenerateCredentialReport service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GenerateCredentialReportResult> generateCredentialReportAsync(
            final GenerateCredentialReportRequest generateCredentialReportRequest,
            final AsyncHandler<GenerateCredentialReportRequest, GenerateCredentialReportResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GenerateCredentialReportResult>() {
            public GenerateCredentialReportResult call() throws Exception {
              GenerateCredentialReportResult result;
                try {
                result = generateCredentialReport(generateCredentialReportRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(generateCredentialReportRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Removes the specified user from the specified group.
     * </p>
     *
     * @param removeUserFromGroupRequest Container for the necessary
     *           parameters to execute the RemoveUserFromGroup operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         RemoveUserFromGroup service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> removeUserFromGroupAsync(final RemoveUserFromGroupRequest removeUserFromGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                removeUserFromGroup(removeUserFromGroupRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Removes the specified user from the specified group.
     * </p>
     *
     * @param removeUserFromGroupRequest Container for the necessary
     *           parameters to execute the RemoveUserFromGroup operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         RemoveUserFromGroup service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> removeUserFromGroupAsync(
            final RemoveUserFromGroupRequest removeUserFromGroupRequest,
            final AsyncHandler<RemoveUserFromGroupRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                removeUserFromGroup(removeUserFromGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(removeUserFromGroupRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists all managed policies that are attached to the specified role.
     * </p>
     * <p>
     * A role can also have inline policies embedded with it. To list the
     * inline policies for a role, use the ListRolePolicies API. For
     * information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. You can use the
     * <code>PathPrefix</code> parameter to limit the list of policies to
     * only those matching the specified path prefix. If there are no
     * policies attached to the specified role (or none that match the
     * specified path prefix), the action returns an empty list.
     * </p>
     *
     * @param listAttachedRolePoliciesRequest Container for the necessary
     *           parameters to execute the ListAttachedRolePolicies operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListAttachedRolePolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAttachedRolePoliciesResult> listAttachedRolePoliciesAsync(final ListAttachedRolePoliciesRequest listAttachedRolePoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAttachedRolePoliciesResult>() {
            public ListAttachedRolePoliciesResult call() throws Exception {
                return listAttachedRolePolicies(listAttachedRolePoliciesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists all managed policies that are attached to the specified role.
     * </p>
     * <p>
     * A role can also have inline policies embedded with it. To list the
     * inline policies for a role, use the ListRolePolicies API. For
     * information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. You can use the
     * <code>PathPrefix</code> parameter to limit the list of policies to
     * only those matching the specified path prefix. If there are no
     * policies attached to the specified role (or none that match the
     * specified path prefix), the action returns an empty list.
     * </p>
     *
     * @param listAttachedRolePoliciesRequest Container for the necessary
     *           parameters to execute the ListAttachedRolePolicies operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListAttachedRolePolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListAttachedRolePoliciesResult> listAttachedRolePoliciesAsync(
            final ListAttachedRolePoliciesRequest listAttachedRolePoliciesRequest,
            final AsyncHandler<ListAttachedRolePoliciesRequest, ListAttachedRolePoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAttachedRolePoliciesResult>() {
            public ListAttachedRolePoliciesResult call() throws Exception {
              ListAttachedRolePoliciesResult result;
                try {
                result = listAttachedRolePolicies(listAttachedRolePoliciesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listAttachedRolePoliciesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified server certificate.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> If you are using a server certificate with Elastic
     * Load Balancing, deleting the certificate could have implications for
     * your application. If Elastic Load Balancing doesn't detect the
     * deletion of bound certificates, it may continue to use the
     * certificates. This could cause Elastic Load Balancing to stop
     * accepting traffic. We recommend that you remove the reference to the
     * certificate from Elastic Load Balancing before using this command to
     * delete the certificate. For more information, go to
     * DeleteLoadBalancerListeners in the Elastic Load Balancing API
     * Reference.
     * </p>
     *
     * @param deleteServerCertificateRequest Container for the necessary
     *           parameters to execute the DeleteServerCertificate operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteServerCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteServerCertificateAsync(final DeleteServerCertificateRequest deleteServerCertificateRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteServerCertificate(deleteServerCertificateRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified server certificate.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> If you are using a server certificate with Elastic
     * Load Balancing, deleting the certificate could have implications for
     * your application. If Elastic Load Balancing doesn't detect the
     * deletion of bound certificates, it may continue to use the
     * certificates. This could cause Elastic Load Balancing to stop
     * accepting traffic. We recommend that you remove the reference to the
     * certificate from Elastic Load Balancing before using this command to
     * delete the certificate. For more information, go to
     * DeleteLoadBalancerListeners in the Elastic Load Balancing API
     * Reference.
     * </p>
     *
     * @param deleteServerCertificateRequest Container for the necessary
     *           parameters to execute the DeleteServerCertificate operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteServerCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteServerCertificateAsync(
            final DeleteServerCertificateRequest deleteServerCertificateRequest,
            final AsyncHandler<DeleteServerCertificateRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteServerCertificate(deleteServerCertificateRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteServerCertificateRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists all users, groups, and roles that the specified managed policy
     * is attached to.
     * </p>
     * <p>
     * You can use the optional <code>EntityFilter</code> parameter to limit
     * the results to a particular type of entity (users, groups, or roles).
     * For example, to list only the roles that are attached to the specified
     * policy, set <code>EntityFilter</code> to <code>Role</code> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listEntitiesForPolicyRequest Container for the necessary
     *           parameters to execute the ListEntitiesForPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListEntitiesForPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListEntitiesForPolicyResult> listEntitiesForPolicyAsync(final ListEntitiesForPolicyRequest listEntitiesForPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListEntitiesForPolicyResult>() {
            public ListEntitiesForPolicyResult call() throws Exception {
                return listEntitiesForPolicy(listEntitiesForPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Lists all users, groups, and roles that the specified managed policy
     * is attached to.
     * </p>
     * <p>
     * You can use the optional <code>EntityFilter</code> parameter to limit
     * the results to a particular type of entity (users, groups, or roles).
     * For example, to list only the roles that are attached to the specified
     * policy, set <code>EntityFilter</code> to <code>Role</code> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listEntitiesForPolicyRequest Container for the necessary
     *           parameters to execute the ListEntitiesForPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListEntitiesForPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListEntitiesForPolicyResult> listEntitiesForPolicyAsync(
            final ListEntitiesForPolicyRequest listEntitiesForPolicyRequest,
            final AsyncHandler<ListEntitiesForPolicyRequest, ListEntitiesForPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListEntitiesForPolicyResult>() {
            public ListEntitiesForPolicyResult call() throws Exception {
              ListEntitiesForPolicyResult result;
                try {
                result = listEntitiesForPolicy(listEntitiesForPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listEntitiesForPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Removes the specified managed policy from the specified group.
     * </p>
     * <p>
     * A group can also have inline policies embedded with it. To delete an
     * inline policy, use the DeleteGroupPolicy API. For information about
     * policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param detachGroupPolicyRequest Container for the necessary parameters
     *           to execute the DetachGroupPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DetachGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> detachGroupPolicyAsync(final DetachGroupPolicyRequest detachGroupPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                detachGroupPolicy(detachGroupPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Removes the specified managed policy from the specified group.
     * </p>
     * <p>
     * A group can also have inline policies embedded with it. To delete an
     * inline policy, use the DeleteGroupPolicy API. For information about
     * policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param detachGroupPolicyRequest Container for the necessary parameters
     *           to execute the DetachGroupPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DetachGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> detachGroupPolicyAsync(
            final DetachGroupPolicyRequest detachGroupPolicyRequest,
            final AsyncHandler<DetachGroupPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                detachGroupPolicy(detachGroupPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(detachGroupPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists the instance profiles that have the specified path prefix. If
     * there are none, the action returns an empty list. For more information
     * about instance profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listInstanceProfilesRequest Container for the necessary
     *           parameters to execute the ListInstanceProfiles operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListInstanceProfiles service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListInstanceProfilesResult> listInstanceProfilesAsync(final ListInstanceProfilesRequest listInstanceProfilesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstanceProfilesResult>() {
            public ListInstanceProfilesResult call() throws Exception {
                return listInstanceProfiles(listInstanceProfilesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the instance profiles that have the specified path prefix. If
     * there are none, the action returns an empty list. For more information
     * about instance profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listInstanceProfilesRequest Container for the necessary
     *           parameters to execute the ListInstanceProfiles operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListInstanceProfiles service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListInstanceProfilesResult> listInstanceProfilesAsync(
            final ListInstanceProfilesRequest listInstanceProfilesRequest,
            final AsyncHandler<ListInstanceProfilesRequest, ListInstanceProfilesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstanceProfilesResult>() {
            public ListInstanceProfilesResult call() throws Exception {
              ListInstanceProfilesResult result;
                try {
                result = listInstanceProfiles(listInstanceProfilesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listInstanceProfilesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Changes the status of the specified access key from Active to
     * Inactive, or vice versa. This action can be used to disable a user's
     * key as part of a key rotation work flow.
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the UserName is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     * <p>
     * For information about rotating keys, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingCredentials.html"> Managing Keys and Certificates </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param updateAccessKeyRequest Container for the necessary parameters
     *           to execute the UpdateAccessKey operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateAccessKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateAccessKeyAsync(final UpdateAccessKeyRequest updateAccessKeyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateAccessKey(updateAccessKeyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Changes the status of the specified access key from Active to
     * Inactive, or vice versa. This action can be used to disable a user's
     * key as part of a key rotation work flow.
     * </p>
     * <p>
     * If the <code>UserName</code> field is not specified, the UserName is
     * determined implicitly based on the AWS access key ID used to sign the
     * request. Because this action works for access keys under the AWS
     * account, you can use this action to manage root credentials even if
     * the AWS account has no associated users.
     * </p>
     * <p>
     * For information about rotating keys, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingCredentials.html"> Managing Keys and Certificates </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param updateAccessKeyRequest Container for the necessary parameters
     *           to execute the UpdateAccessKey operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateAccessKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateAccessKeyAsync(
            final UpdateAccessKeyRequest updateAccessKeyRequest,
            final AsyncHandler<UpdateAccessKeyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateAccessKey(updateAccessKeyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateAccessKeyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns information about the specified OpenID Connect provider.
     * </p>
     *
     * @param getOpenIDConnectProviderRequest Container for the necessary
     *           parameters to execute the GetOpenIDConnectProvider operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetOpenIDConnectProviderResult> getOpenIDConnectProviderAsync(final GetOpenIDConnectProviderRequest getOpenIDConnectProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetOpenIDConnectProviderResult>() {
            public GetOpenIDConnectProviderResult call() throws Exception {
                return getOpenIDConnectProvider(getOpenIDConnectProviderRequest);
        }
    });
    }

    /**
     * <p>
     * Returns information about the specified OpenID Connect provider.
     * </p>
     *
     * @param getOpenIDConnectProviderRequest Container for the necessary
     *           parameters to execute the GetOpenIDConnectProvider operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetOpenIDConnectProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetOpenIDConnectProviderResult> getOpenIDConnectProviderAsync(
            final GetOpenIDConnectProviderRequest getOpenIDConnectProviderRequest,
            final AsyncHandler<GetOpenIDConnectProviderRequest, GetOpenIDConnectProviderResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetOpenIDConnectProviderResult>() {
            public GetOpenIDConnectProviderResult call() throws Exception {
              GetOpenIDConnectProviderResult result;
                try {
                result = getOpenIDConnectProvider(getOpenIDConnectProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getOpenIDConnectProviderRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Adds the specified user to the specified group.
     * </p>
     *
     * @param addUserToGroupRequest Container for the necessary parameters to
     *           execute the AddUserToGroup operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         AddUserToGroup service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> addUserToGroupAsync(final AddUserToGroupRequest addUserToGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                addUserToGroup(addUserToGroupRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Adds the specified user to the specified group.
     * </p>
     *
     * @param addUserToGroupRequest Container for the necessary parameters to
     *           execute the AddUserToGroup operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         AddUserToGroup service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> addUserToGroupAsync(
            final AddUserToGroupRequest addUserToGroupRequest,
            final AsyncHandler<AddUserToGroupRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                addUserToGroup(addUserToGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(addUserToGroupRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns a list of users that are in the specified group. You can
     * paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param getGroupRequest Container for the necessary parameters to
     *           execute the GetGroup operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the GetGroup
     *         service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetGroupResult> getGroupAsync(final GetGroupRequest getGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetGroupResult>() {
            public GetGroupResult call() throws Exception {
                return getGroup(getGroupRequest);
        }
    });
    }

    /**
     * <p>
     * Returns a list of users that are in the specified group. You can
     * paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param getGroupRequest Container for the necessary parameters to
     *           execute the GetGroup operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the GetGroup
     *         service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetGroupResult> getGroupAsync(
            final GetGroupRequest getGroupRequest,
            final AsyncHandler<GetGroupRequest, GetGroupResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetGroupResult>() {
            public GetGroupResult call() throws Exception {
              GetGroupResult result;
                try {
                result = getGroup(getGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getGroupRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified group. The group must not contain any users or
     * have any attached policies.
     * </p>
     *
     * @param deleteGroupRequest Container for the necessary parameters to
     *           execute the DeleteGroup operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteGroup service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteGroupAsync(final DeleteGroupRequest deleteGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteGroup(deleteGroupRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified group. The group must not contain any users or
     * have any attached policies.
     * </p>
     *
     * @param deleteGroupRequest Container for the necessary parameters to
     *           execute the DeleteGroup operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteGroup service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteGroupAsync(
            final DeleteGroupRequest deleteGroupRequest,
            final AsyncHandler<DeleteGroupRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteGroup(deleteGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteGroupRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Removes the specified managed policy from the specified user.
     * </p>
     * <p>
     * A user can also have inline policies embedded with it. To delete an
     * inline policy, use the DeleteUserPolicy API. For information about
     * policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param detachUserPolicyRequest Container for the necessary parameters
     *           to execute the DetachUserPolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DetachUserPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> detachUserPolicyAsync(final DetachUserPolicyRequest detachUserPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                detachUserPolicy(detachUserPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Removes the specified managed policy from the specified user.
     * </p>
     * <p>
     * A user can also have inline policies embedded with it. To delete an
     * inline policy, use the DeleteUserPolicy API. For information about
     * policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param detachUserPolicyRequest Container for the necessary parameters
     *           to execute the DetachUserPolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DetachUserPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> detachUserPolicyAsync(
            final DetachUserPolicyRequest detachUserPolicyRequest,
            final AsyncHandler<DetachUserPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                detachUserPolicy(detachUserPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(detachUserPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified instance profile. The instance profile must not
     * have an associated role.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Make sure you do not have any Amazon EC2 instances
     * running with the instance profile you are about to delete. Deleting a
     * role or instance profile that is associated with a running instance
     * will break any applications running on the instance.
     * </p>
     * <p>
     * For more information about instance profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     *
     * @param deleteInstanceProfileRequest Container for the necessary
     *           parameters to execute the DeleteInstanceProfile operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteInstanceProfileAsync(final DeleteInstanceProfileRequest deleteInstanceProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteInstanceProfile(deleteInstanceProfileRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified instance profile. The instance profile must not
     * have an associated role.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Make sure you do not have any Amazon EC2 instances
     * running with the instance profile you are about to delete. Deleting a
     * role or instance profile that is associated with a running instance
     * will break any applications running on the instance.
     * </p>
     * <p>
     * For more information about instance profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     *
     * @param deleteInstanceProfileRequest Container for the necessary
     *           parameters to execute the DeleteInstanceProfile operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteInstanceProfileAsync(
            final DeleteInstanceProfileRequest deleteInstanceProfileRequest,
            final AsyncHandler<DeleteInstanceProfileRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteInstanceProfile(deleteInstanceProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteInstanceProfileRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns the SAML provider metadocument that was uploaded when the
     * provider was created or updated.
     * </p>
     * <p>
     * <b>NOTE:</b>This operation requires Signature Version 4.
     * </p>
     *
     * @param getSAMLProviderRequest Container for the necessary parameters
     *           to execute the GetSAMLProvider operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetSAMLProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetSAMLProviderResult> getSAMLProviderAsync(final GetSAMLProviderRequest getSAMLProviderRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetSAMLProviderResult>() {
            public GetSAMLProviderResult call() throws Exception {
                return getSAMLProvider(getSAMLProviderRequest);
        }
    });
    }

    /**
     * <p>
     * Returns the SAML provider metadocument that was uploaded when the
     * provider was created or updated.
     * </p>
     * <p>
     * <b>NOTE:</b>This operation requires Signature Version 4.
     * </p>
     *
     * @param getSAMLProviderRequest Container for the necessary parameters
     *           to execute the GetSAMLProvider operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetSAMLProvider service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetSAMLProviderResult> getSAMLProviderAsync(
            final GetSAMLProviderRequest getSAMLProviderRequest,
            final AsyncHandler<GetSAMLProviderRequest, GetSAMLProviderResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetSAMLProviderResult>() {
            public GetSAMLProviderResult call() throws Exception {
              GetSAMLProviderResult result;
                try {
                result = getSAMLProvider(getSAMLProviderRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getSAMLProviderRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new role for your AWS account. For more information about
     * roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a> . For information about limitations on role names and the number of roles you can create, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * The policy in the following example grants permission to an EC2
     * instance to assume the role.
     * </p>
     *
     * @param createRoleRequest Container for the necessary parameters to
     *           execute the CreateRole operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreateRole service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateRoleResult> createRoleAsync(final CreateRoleRequest createRoleRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateRoleResult>() {
            public CreateRoleResult call() throws Exception {
                return createRole(createRoleRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a new role for your AWS account. For more information about
     * roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a> . For information about limitations on role names and the number of roles you can create, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html"> Limitations on IAM Entities </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * The policy in the following example grants permission to an EC2
     * instance to assume the role.
     * </p>
     *
     * @param createRoleRequest Container for the necessary parameters to
     *           execute the CreateRole operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateRole service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateRoleResult> createRoleAsync(
            final CreateRoleRequest createRoleRequest,
            final AsyncHandler<CreateRoleRequest, CreateRoleResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateRoleResult>() {
            public CreateRoleResult call() throws Exception {
              CreateRoleResult result;
                try {
                result = createRole(createRoleRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createRoleRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Changes the password for the specified user.
     * </p>
     * <p>
     * Users can change their own passwords by calling ChangePassword. For
     * more information about modifying passwords, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingLogins.html"> Managing Passwords </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param updateLoginProfileRequest Container for the necessary
     *           parameters to execute the UpdateLoginProfile operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateLoginProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateLoginProfileAsync(final UpdateLoginProfileRequest updateLoginProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateLoginProfile(updateLoginProfileRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Changes the password for the specified user.
     * </p>
     * <p>
     * Users can change their own passwords by calling ChangePassword. For
     * more information about modifying passwords, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingLogins.html"> Managing Passwords </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param updateLoginProfileRequest Container for the necessary
     *           parameters to execute the UpdateLoginProfile operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateLoginProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateLoginProfileAsync(
            final UpdateLoginProfileRequest updateLoginProfileRequest,
            final AsyncHandler<UpdateLoginProfileRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateLoginProfile(updateLoginProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateLoginProfileRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the password for the specified user, which terminates the
     * user's ability to access AWS services through the AWS Management
     * Console.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Deleting a user's password does not prevent a user
     * from accessing IAM through the command line interface or the API. To
     * prevent all user access you must also either make the access key
     * inactive or delete it. For more information about making keys inactive
     * or deleting them, see UpdateAccessKey and DeleteAccessKey.
     * </p>
     *
     * @param deleteLoginProfileRequest Container for the necessary
     *           parameters to execute the DeleteLoginProfile operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLoginProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteLoginProfileAsync(final DeleteLoginProfileRequest deleteLoginProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteLoginProfile(deleteLoginProfileRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the password for the specified user, which terminates the
     * user's ability to access AWS services through the AWS Management
     * Console.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Deleting a user's password does not prevent a user
     * from accessing IAM through the command line interface or the API. To
     * prevent all user access you must also either make the access key
     * inactive or delete it. For more information about making keys inactive
     * or deleting them, see UpdateAccessKey and DeleteAccessKey.
     * </p>
     *
     * @param deleteLoginProfileRequest Container for the necessary
     *           parameters to execute the DeleteLoginProfile operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLoginProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteLoginProfileAsync(
            final DeleteLoginProfileRequest deleteLoginProfileRequest,
            final AsyncHandler<DeleteLoginProfileRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteLoginProfile(deleteLoginProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteLoginProfileRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Uploads an SSH public key and associates it with the specified IAM
     * user.
     * </p>
     * <p>
     * The SSH public key uploaded by this action can be used only for
     * authenticating the associated IAM user to an AWS CodeCommit
     * repository. For more information about using SSH keys to authenticate
     * to an AWS CodeCommit repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     *
     * @param uploadSSHPublicKeyRequest Container for the necessary
     *           parameters to execute the UploadSSHPublicKey operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         UploadSSHPublicKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<UploadSSHPublicKeyResult> uploadSSHPublicKeyAsync(final UploadSSHPublicKeyRequest uploadSSHPublicKeyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UploadSSHPublicKeyResult>() {
            public UploadSSHPublicKeyResult call() throws Exception {
                return uploadSSHPublicKey(uploadSSHPublicKeyRequest);
        }
    });
    }

    /**
     * <p>
     * Uploads an SSH public key and associates it with the specified IAM
     * user.
     * </p>
     * <p>
     * The SSH public key uploaded by this action can be used only for
     * authenticating the associated IAM user to an AWS CodeCommit
     * repository. For more information about using SSH keys to authenticate
     * to an AWS CodeCommit repository, see
     * <a href="http://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-credentials-ssh.html"> Set up AWS CodeCommit for SSH Connections </a>
     * in the <i>AWS CodeCommit User Guide</i> .
     * </p>
     *
     * @param uploadSSHPublicKeyRequest Container for the necessary
     *           parameters to execute the UploadSSHPublicKey operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UploadSSHPublicKey service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<UploadSSHPublicKeyResult> uploadSSHPublicKeyAsync(
            final UploadSSHPublicKeyRequest uploadSSHPublicKeyRequest,
            final AsyncHandler<UploadSSHPublicKeyRequest, UploadSSHPublicKeyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UploadSSHPublicKeyResult>() {
            public UploadSSHPublicKeyResult call() throws Exception {
              UploadSSHPublicKeyResult result;
                try {
                result = uploadSSHPublicKey(uploadSSHPublicKeyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(uploadSSHPublicKeyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Simulate the set of IAM policies attached to an IAM entity against a
     * list of API actions and AWS resources to determine the policies'
     * effective permissions. The entity can be an IAM user, group, or role.
     * If you specify a user, then the simulation also includes all of the
     * policies attached to groups that the user is a member of.
     * </p>
     * <p>
     * You can optionally include a list of one or more additional policies
     * specified as strings to include in the simulation. If you want to
     * simulate only policies specified as strings, use SimulateCustomPolicy
     * instead.
     * </p>
     * <p>
     * The simulation does not perform the API actions, it only checks the
     * authorization to determine if the simulated policies allow or deny the
     * actions.
     * </p>
     * <p>
     * <b>Note:</b> This API discloses information about the permissions
     * granted to other users. If you do not want users to see other user's
     * permissions, then consider allowing them to use SimulateCustomPolicy
     * instead.
     * </p>
     * <p>
     * Context keys are variables maintained by AWS and its services that
     * provide details about the context of an API query request, and can be
     * evaluated by using the <code>Condition</code> element of an IAM
     * policy. To get the list of context keys required by the policies to
     * simulate them correctly, use GetContextKeysForPrincipalPolicy.
     * </p>
     * <p>
     * If the output is long, you can paginate the results using the
     * <code>MaxItems</code> and <code>Marker</code> parameters.
     * </p>
     *
     * @param simulatePrincipalPolicyRequest Container for the necessary
     *           parameters to execute the SimulatePrincipalPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         SimulatePrincipalPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SimulatePrincipalPolicyResult> simulatePrincipalPolicyAsync(final SimulatePrincipalPolicyRequest simulatePrincipalPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SimulatePrincipalPolicyResult>() {
            public SimulatePrincipalPolicyResult call() throws Exception {
                return simulatePrincipalPolicy(simulatePrincipalPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Simulate the set of IAM policies attached to an IAM entity against a
     * list of API actions and AWS resources to determine the policies'
     * effective permissions. The entity can be an IAM user, group, or role.
     * If you specify a user, then the simulation also includes all of the
     * policies attached to groups that the user is a member of.
     * </p>
     * <p>
     * You can optionally include a list of one or more additional policies
     * specified as strings to include in the simulation. If you want to
     * simulate only policies specified as strings, use SimulateCustomPolicy
     * instead.
     * </p>
     * <p>
     * The simulation does not perform the API actions, it only checks the
     * authorization to determine if the simulated policies allow or deny the
     * actions.
     * </p>
     * <p>
     * <b>Note:</b> This API discloses information about the permissions
     * granted to other users. If you do not want users to see other user's
     * permissions, then consider allowing them to use SimulateCustomPolicy
     * instead.
     * </p>
     * <p>
     * Context keys are variables maintained by AWS and its services that
     * provide details about the context of an API query request, and can be
     * evaluated by using the <code>Condition</code> element of an IAM
     * policy. To get the list of context keys required by the policies to
     * simulate them correctly, use GetContextKeysForPrincipalPolicy.
     * </p>
     * <p>
     * If the output is long, you can paginate the results using the
     * <code>MaxItems</code> and <code>Marker</code> parameters.
     * </p>
     *
     * @param simulatePrincipalPolicyRequest Container for the necessary
     *           parameters to execute the SimulatePrincipalPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SimulatePrincipalPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SimulatePrincipalPolicyResult> simulatePrincipalPolicyAsync(
            final SimulatePrincipalPolicyRequest simulatePrincipalPolicyRequest,
            final AsyncHandler<SimulatePrincipalPolicyRequest, SimulatePrincipalPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SimulatePrincipalPolicyResult>() {
            public SimulatePrincipalPolicyResult call() throws Exception {
              SimulatePrincipalPolicyResult result;
                try {
                result = simulatePrincipalPolicy(simulatePrincipalPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(simulatePrincipalPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Attaches the specified managed policy to the specified user.
     * </p>
     * <p>
     * You use this API to attach a managed policy to a user. To embed an
     * inline policy in a user, use PutUserPolicy.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param attachUserPolicyRequest Container for the necessary parameters
     *           to execute the AttachUserPolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         AttachUserPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> attachUserPolicyAsync(final AttachUserPolicyRequest attachUserPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                attachUserPolicy(attachUserPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Attaches the specified managed policy to the specified user.
     * </p>
     * <p>
     * You use this API to attach a managed policy to a user. To embed an
     * inline policy in a user, use PutUserPolicy.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param attachUserPolicyRequest Container for the necessary parameters
     *           to execute the AttachUserPolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         AttachUserPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> attachUserPolicyAsync(
            final AttachUserPolicyRequest attachUserPolicyRequest,
            final AsyncHandler<AttachUserPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                attachUserPolicy(attachUserPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(attachUserPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about the specified server certificate.
     * </p>
     *
     * @param getServerCertificateRequest Container for the necessary
     *           parameters to execute the GetServerCertificate operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetServerCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetServerCertificateResult> getServerCertificateAsync(final GetServerCertificateRequest getServerCertificateRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetServerCertificateResult>() {
            public GetServerCertificateResult call() throws Exception {
                return getServerCertificate(getServerCertificateRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about the specified server certificate.
     * </p>
     *
     * @param getServerCertificateRequest Container for the necessary
     *           parameters to execute the GetServerCertificate operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetServerCertificate service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetServerCertificateResult> getServerCertificateAsync(
            final GetServerCertificateRequest getServerCertificateRequest,
            final AsyncHandler<GetServerCertificateRequest, GetServerCertificateResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetServerCertificateResult>() {
            public GetServerCertificateResult call() throws Exception {
              GetServerCertificateResult result;
                try {
                result = getServerCertificate(getServerCertificateRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getServerCertificateRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Attaches the specified managed policy to the specified group.
     * </p>
     * <p>
     * You use this API to attach a managed policy to a group. To embed an
     * inline policy in a group, use PutGroupPolicy.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param attachGroupPolicyRequest Container for the necessary parameters
     *           to execute the AttachGroupPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         AttachGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> attachGroupPolicyAsync(final AttachGroupPolicyRequest attachGroupPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                attachGroupPolicy(attachGroupPolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Attaches the specified managed policy to the specified group.
     * </p>
     * <p>
     * You use this API to attach a managed policy to a group. To embed an
     * inline policy in a group, use PutGroupPolicy.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param attachGroupPolicyRequest Container for the necessary parameters
     *           to execute the AttachGroupPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         AttachGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> attachGroupPolicyAsync(
            final AttachGroupPolicyRequest attachGroupPolicyRequest,
            final AsyncHandler<AttachGroupPolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                attachGroupPolicy(attachGroupPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(attachGroupPolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Sets the specified version of the specified policy as the policy's
     * default (operative) version.
     * </p>
     * <p>
     * This action affects all users, groups, and roles that the policy is
     * attached to. To list the users, groups, and roles that the policy is
     * attached to, use the ListEntitiesForPolicy API.
     * </p>
     * <p>
     * For information about managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param setDefaultPolicyVersionRequest Container for the necessary
     *           parameters to execute the SetDefaultPolicyVersion operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         SetDefaultPolicyVersion service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> setDefaultPolicyVersionAsync(final SetDefaultPolicyVersionRequest setDefaultPolicyVersionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                setDefaultPolicyVersion(setDefaultPolicyVersionRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Sets the specified version of the specified policy as the policy's
     * default (operative) version.
     * </p>
     * <p>
     * This action affects all users, groups, and roles that the policy is
     * attached to. To list the users, groups, and roles that the policy is
     * attached to, use the ListEntitiesForPolicy API.
     * </p>
     * <p>
     * For information about managed policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param setDefaultPolicyVersionRequest Container for the necessary
     *           parameters to execute the SetDefaultPolicyVersion operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SetDefaultPolicyVersion service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> setDefaultPolicyVersionAsync(
            final SetDefaultPolicyVersionRequest setDefaultPolicyVersionRequest,
            final AsyncHandler<SetDefaultPolicyVersionRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                setDefaultPolicyVersion(setDefaultPolicyVersionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(setDefaultPolicyVersionRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists the names of the inline policies embedded in the specified
     * user.
     * </p>
     * <p>
     * A user can also have managed policies attached to it. To list the
     * managed policies that are attached to a user, use
     * ListAttachedUserPolicies. For more information about policies, refer
     * to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. If there are no inline policies
     * embedded with the specified user, the action returns an empty list.
     * </p>
     *
     * @param listUserPoliciesRequest Container for the necessary parameters
     *           to execute the ListUserPolicies operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListUserPolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListUserPoliciesResult> listUserPoliciesAsync(final ListUserPoliciesRequest listUserPoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUserPoliciesResult>() {
            public ListUserPoliciesResult call() throws Exception {
                return listUserPolicies(listUserPoliciesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the names of the inline policies embedded in the specified
     * user.
     * </p>
     * <p>
     * A user can also have managed policies attached to it. To list the
     * managed policies that are attached to a user, use
     * ListAttachedUserPolicies. For more information about policies, refer
     * to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. If there are no inline policies
     * embedded with the specified user, the action returns an empty list.
     * </p>
     *
     * @param listUserPoliciesRequest Container for the necessary parameters
     *           to execute the ListUserPolicies operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListUserPolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListUserPoliciesResult> listUserPoliciesAsync(
            final ListUserPoliciesRequest listUserPoliciesRequest,
            final AsyncHandler<ListUserPoliciesRequest, ListUserPoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUserPoliciesResult>() {
            public ListUserPoliciesResult call() throws Exception {
              ListUserPoliciesResult result;
                try {
                result = listUserPolicies(listUserPoliciesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listUserPoliciesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves information about when the specified access key was last
     * used. The information includes the date and time of last use, along
     * with the AWS service and region that were specified in the last
     * request made with that key.
     * </p>
     *
     * @param getAccessKeyLastUsedRequest Container for the necessary
     *           parameters to execute the GetAccessKeyLastUsed operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetAccessKeyLastUsed service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAccessKeyLastUsedResult> getAccessKeyLastUsedAsync(final GetAccessKeyLastUsedRequest getAccessKeyLastUsedRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAccessKeyLastUsedResult>() {
            public GetAccessKeyLastUsedResult call() throws Exception {
                return getAccessKeyLastUsed(getAccessKeyLastUsedRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves information about when the specified access key was last
     * used. The information includes the date and time of last use, along
     * with the AWS service and region that were specified in the last
     * request made with that key.
     * </p>
     *
     * @param getAccessKeyLastUsedRequest Container for the necessary
     *           parameters to execute the GetAccessKeyLastUsed operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetAccessKeyLastUsed service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAccessKeyLastUsedResult> getAccessKeyLastUsedAsync(
            final GetAccessKeyLastUsedRequest getAccessKeyLastUsedRequest,
            final AsyncHandler<GetAccessKeyLastUsedRequest, GetAccessKeyLastUsedResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAccessKeyLastUsedResult>() {
            public GetAccessKeyLastUsedResult call() throws Exception {
              GetAccessKeyLastUsedResult result;
                try {
                result = getAccessKeyLastUsed(getAccessKeyLastUsedRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getAccessKeyLastUsedRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists the groups the specified user belongs to.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listGroupsForUserRequest Container for the necessary parameters
     *           to execute the ListGroupsForUser operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListGroupsForUser service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListGroupsForUserResult> listGroupsForUserAsync(final ListGroupsForUserRequest listGroupsForUserRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListGroupsForUserResult>() {
            public ListGroupsForUserResult call() throws Exception {
                return listGroupsForUser(listGroupsForUserRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the groups the specified user belongs to.
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listGroupsForUserRequest Container for the necessary parameters
     *           to execute the ListGroupsForUser operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListGroupsForUser service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListGroupsForUserResult> listGroupsForUserAsync(
            final ListGroupsForUserRequest listGroupsForUserRequest,
            final AsyncHandler<ListGroupsForUserRequest, ListGroupsForUserResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListGroupsForUserResult>() {
            public ListGroupsForUserResult call() throws Exception {
              ListGroupsForUserResult result;
                try {
                result = listGroupsForUser(listGroupsForUserRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listGroupsForUserRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new version of the specified managed policy. To update a
     * managed policy, you create a new policy version. A managed policy can
     * have up to five versions. If the policy has five versions, you must
     * delete an existing version using DeletePolicyVersion before you create
     * a new version.
     * </p>
     * <p>
     * Optionally, you can set the new version as the policy's default
     * version. The default version is the operative version; that is, the
     * version that is in effect for the IAM users, groups, and roles that
     * the policy is attached to.
     * </p>
     * <p>
     * For more information about managed policy versions, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-versions.html"> Versioning for Managed Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createPolicyVersionRequest Container for the necessary
     *           parameters to execute the CreatePolicyVersion operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         CreatePolicyVersion service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreatePolicyVersionResult> createPolicyVersionAsync(final CreatePolicyVersionRequest createPolicyVersionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreatePolicyVersionResult>() {
            public CreatePolicyVersionResult call() throws Exception {
                return createPolicyVersion(createPolicyVersionRequest);
        }
    });
    }

    /**
     * <p>
     * Creates a new version of the specified managed policy. To update a
     * managed policy, you create a new policy version. A managed policy can
     * have up to five versions. If the policy has five versions, you must
     * delete an existing version using DeletePolicyVersion before you create
     * a new version.
     * </p>
     * <p>
     * Optionally, you can set the new version as the policy's default
     * version. The default version is the operative version; that is, the
     * version that is in effect for the IAM users, groups, and roles that
     * the policy is attached to.
     * </p>
     * <p>
     * For more information about managed policy versions, see
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-versions.html"> Versioning for Managed Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param createPolicyVersionRequest Container for the necessary
     *           parameters to execute the CreatePolicyVersion operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreatePolicyVersion service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreatePolicyVersionResult> createPolicyVersionAsync(
            final CreatePolicyVersionRequest createPolicyVersionRequest,
            final AsyncHandler<CreatePolicyVersionRequest, CreatePolicyVersionResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreatePolicyVersionResult>() {
            public CreatePolicyVersionResult call() throws Exception {
              CreatePolicyVersionResult result;
                try {
                result = createPolicyVersion(createPolicyVersionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createPolicyVersionRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Adds the specified role to the specified instance profile. For more
     * information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a> . For more information about instance profiles, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     *
     * @param addRoleToInstanceProfileRequest Container for the necessary
     *           parameters to execute the AddRoleToInstanceProfile operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         AddRoleToInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> addRoleToInstanceProfileAsync(final AddRoleToInstanceProfileRequest addRoleToInstanceProfileRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                addRoleToInstanceProfile(addRoleToInstanceProfileRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Adds the specified role to the specified instance profile. For more
     * information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a> . For more information about instance profiles, go to <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     *
     * @param addRoleToInstanceProfileRequest Container for the necessary
     *           parameters to execute the AddRoleToInstanceProfile operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         AddRoleToInstanceProfile service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> addRoleToInstanceProfileAsync(
            final AddRoleToInstanceProfileRequest addRoleToInstanceProfileRequest,
            final AsyncHandler<AddRoleToInstanceProfileRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                addRoleToInstanceProfile(addRoleToInstanceProfileRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(addRoleToInstanceProfileRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves the specified inline policy document that is embedded in
     * the specified group.
     * </p>
     * <p>
     * A group can also have managed policies attached to it. To retrieve a
     * managed policy document that is attached to a group, use GetPolicy to
     * determine the policy's default version, then use GetPolicyVersion to
     * retrieve the policy document.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getGroupPolicyRequest Container for the necessary parameters to
     *           execute the GetGroupPolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetGroupPolicyResult> getGroupPolicyAsync(final GetGroupPolicyRequest getGroupPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetGroupPolicyResult>() {
            public GetGroupPolicyResult call() throws Exception {
                return getGroupPolicy(getGroupPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves the specified inline policy document that is embedded in
     * the specified group.
     * </p>
     * <p>
     * A group can also have managed policies attached to it. To retrieve a
     * managed policy document that is attached to a group, use GetPolicy to
     * determine the policy's default version, then use GetPolicyVersion to
     * retrieve the policy document.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param getGroupPolicyRequest Container for the necessary parameters to
     *           execute the GetGroupPolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetGroupPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetGroupPolicyResult> getGroupPolicyAsync(
            final GetGroupPolicyRequest getGroupPolicyRequest,
            final AsyncHandler<GetGroupPolicyRequest, GetGroupPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetGroupPolicyResult>() {
            public GetGroupPolicyResult call() throws Exception {
              GetGroupPolicyResult result;
                try {
                result = getGroupPolicy(getGroupPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getGroupPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves the specified inline policy document that is embedded with
     * the specified role.
     * </p>
     * <p>
     * A role can also have managed policies attached to it. To retrieve a
     * managed policy document that is attached to a role, use GetPolicy to
     * determine the policy's default version, then use GetPolicyVersion to
     * retrieve the policy document.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For more information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/roles-toplevel.html"> Using Roles to Delegate Permissions and Federate Identities </a>
     * .
     * </p>
     *
     * @param getRolePolicyRequest Container for the necessary parameters to
     *           execute the GetRolePolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetRolePolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetRolePolicyResult> getRolePolicyAsync(final GetRolePolicyRequest getRolePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetRolePolicyResult>() {
            public GetRolePolicyResult call() throws Exception {
                return getRolePolicy(getRolePolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves the specified inline policy document that is embedded with
     * the specified role.
     * </p>
     * <p>
     * A role can also have managed policies attached to it. To retrieve a
     * managed policy document that is attached to a role, use GetPolicy to
     * determine the policy's default version, then use GetPolicyVersion to
     * retrieve the policy document.
     * </p>
     * <p>
     * For more information about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * For more information about roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/roles-toplevel.html"> Using Roles to Delegate Permissions and Federate Identities </a>
     * .
     * </p>
     *
     * @param getRolePolicyRequest Container for the necessary parameters to
     *           execute the GetRolePolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetRolePolicy service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetRolePolicyResult> getRolePolicyAsync(
            final GetRolePolicyRequest getRolePolicyRequest,
            final AsyncHandler<GetRolePolicyRequest, GetRolePolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetRolePolicyResult>() {
            public GetRolePolicyResult call() throws Exception {
              GetRolePolicyResult result;
                try {
                result = getRolePolicy(getRolePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getRolePolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists the instance profiles that have the specified associated role.
     * If there are none, the action returns an empty list. For more
     * information about instance profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listInstanceProfilesForRoleRequest Container for the necessary
     *           parameters to execute the ListInstanceProfilesForRole operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListInstanceProfilesForRole service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListInstanceProfilesForRoleResult> listInstanceProfilesForRoleAsync(final ListInstanceProfilesForRoleRequest listInstanceProfilesForRoleRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstanceProfilesForRoleResult>() {
            public ListInstanceProfilesForRoleResult call() throws Exception {
                return listInstanceProfilesForRole(listInstanceProfilesForRoleRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the instance profiles that have the specified associated role.
     * If there are none, the action returns an empty list. For more
     * information about instance profiles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/AboutInstanceProfiles.html"> About Instance Profiles </a>
     * .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listInstanceProfilesForRoleRequest Container for the necessary
     *           parameters to execute the ListInstanceProfilesForRole operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListInstanceProfilesForRole service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListInstanceProfilesForRoleResult> listInstanceProfilesForRoleAsync(
            final ListInstanceProfilesForRoleRequest listInstanceProfilesForRoleRequest,
            final AsyncHandler<ListInstanceProfilesForRoleRequest, ListInstanceProfilesForRoleResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstanceProfilesForRoleResult>() {
            public ListInstanceProfilesForRoleResult call() throws Exception {
              ListInstanceProfilesForRoleResult result;
                try {
                result = listInstanceProfilesForRole(listInstanceProfilesForRoleRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listInstanceProfilesForRoleRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified inline policy that is embedded in the specified
     * role.
     * </p>
     * <p>
     * A role can also have managed policies attached to it. To detach a
     * managed policy from a role, use DetachRolePolicy. For more information
     * about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deleteRolePolicyRequest Container for the necessary parameters
     *           to execute the DeleteRolePolicy operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteRolePolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteRolePolicyAsync(final DeleteRolePolicyRequest deleteRolePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteRolePolicy(deleteRolePolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified inline policy that is embedded in the specified
     * role.
     * </p>
     * <p>
     * A role can also have managed policies attached to it. To detach a
     * managed policy from a role, use DetachRolePolicy. For more information
     * about policies, refer to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     *
     * @param deleteRolePolicyRequest Container for the necessary parameters
     *           to execute the DeleteRolePolicy operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteRolePolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteRolePolicyAsync(
            final DeleteRolePolicyRequest deleteRolePolicyRequest,
            final AsyncHandler<DeleteRolePolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteRolePolicy(deleteRolePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteRolePolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Lists the virtual MFA devices under the AWS account by assignment
     * status. If you do not specify an assignment status, the action returns
     * a list of all virtual MFA devices. Assignment status can be
     * <code>Assigned</code> , <code>Unassigned</code> , or <code>Any</code>
     * .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listVirtualMFADevicesRequest Container for the necessary
     *           parameters to execute the ListVirtualMFADevices operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListVirtualMFADevices service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(final ListVirtualMFADevicesRequest listVirtualMFADevicesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListVirtualMFADevicesResult>() {
            public ListVirtualMFADevicesResult call() throws Exception {
                return listVirtualMFADevices(listVirtualMFADevicesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the virtual MFA devices under the AWS account by assignment
     * status. If you do not specify an assignment status, the action returns
     * a list of all virtual MFA devices. Assignment status can be
     * <code>Assigned</code> , <code>Unassigned</code> , or <code>Any</code>
     * .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listVirtualMFADevicesRequest Container for the necessary
     *           parameters to execute the ListVirtualMFADevices operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListVirtualMFADevices service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(
            final ListVirtualMFADevicesRequest listVirtualMFADevicesRequest,
            final AsyncHandler<ListVirtualMFADevicesRequest, ListVirtualMFADevicesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListVirtualMFADevicesResult>() {
            public ListVirtualMFADevicesResult call() throws Exception {
              ListVirtualMFADevicesResult result;
                try {
                result = listVirtualMFADevices(listVirtualMFADevicesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listVirtualMFADevicesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists the names of the inline policies that are embedded in the
     * specified group.
     * </p>
     * <p>
     * A group can also have managed policies attached to it. To list the
     * managed policies that are attached to a group, use
     * ListAttachedGroupPolicies. For more information about policies, refer
     * to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. If there are no inline policies
     * embedded with the specified group, the action returns an empty list.
     * </p>
     *
     * @param listGroupPoliciesRequest Container for the necessary parameters
     *           to execute the ListGroupPolicies operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListGroupPolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListGroupPoliciesResult> listGroupPoliciesAsync(final ListGroupPoliciesRequest listGroupPoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListGroupPoliciesResult>() {
            public ListGroupPoliciesResult call() throws Exception {
                return listGroupPolicies(listGroupPoliciesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the names of the inline policies that are embedded in the
     * specified group.
     * </p>
     * <p>
     * A group can also have managed policies attached to it. To list the
     * managed policies that are attached to a group, use
     * ListAttachedGroupPolicies. For more information about policies, refer
     * to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/policies-managed-vs-inline.html"> Managed Policies and Inline Policies </a>
     * in the <i>IAM User Guide</i> .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters. If there are no inline policies
     * embedded with the specified group, the action returns an empty list.
     * </p>
     *
     * @param listGroupPoliciesRequest Container for the necessary parameters
     *           to execute the ListGroupPolicies operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListGroupPolicies service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListGroupPoliciesResult> listGroupPoliciesAsync(
            final ListGroupPoliciesRequest listGroupPoliciesRequest,
            final AsyncHandler<ListGroupPoliciesRequest, ListGroupPoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListGroupPoliciesResult>() {
            public ListGroupPoliciesResult call() throws Exception {
              ListGroupPoliciesResult result;
                try {
                result = listGroupPolicies(listGroupPoliciesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listGroupPoliciesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists the roles that have the specified path prefix. If there are
     * none, the action returns an empty list. For more information about
     * roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a>
     * .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listRolesRequest Container for the necessary parameters to
     *           execute the ListRoles operation on AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         ListRoles service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListRolesResult> listRolesAsync(final ListRolesRequest listRolesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListRolesResult>() {
            public ListRolesResult call() throws Exception {
                return listRoles(listRolesRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the roles that have the specified path prefix. If there are
     * none, the action returns an empty list. For more information about
     * roles, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html"> Working with Roles </a>
     * .
     * </p>
     * <p>
     * You can paginate the results using the <code>MaxItems</code> and
     * <code>Marker</code> parameters.
     * </p>
     *
     * @param listRolesRequest Container for the necessary parameters to
     *           execute the ListRoles operation on AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ListRoles service method, as returned by AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListRolesResult> listRolesAsync(
            final ListRolesRequest listRolesRequest,
            final AsyncHandler<ListRolesRequest, ListRolesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListRolesResult>() {
            public ListRolesResult call() throws Exception {
              ListRolesResult result;
                try {
                result = listRoles(listRolesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(listRolesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Retrieves the password policy for the AWS account. For more
     * information about using a password policy, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingPasswordPolicies.html"> Managing an IAM Password Policy </a>
     * .
     * </p>
     *
     * @param getAccountPasswordPolicyRequest Container for the necessary
     *           parameters to execute the GetAccountPasswordPolicy operation on
     *           AmazonIdentityManagement.
     * 
     * @return A Java Future object containing the response from the
     *         GetAccountPasswordPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(final GetAccountPasswordPolicyRequest getAccountPasswordPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAccountPasswordPolicyResult>() {
            public GetAccountPasswordPolicyResult call() throws Exception {
                return getAccountPasswordPolicy(getAccountPasswordPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Retrieves the password policy for the AWS account. For more
     * information about using a password policy, go to
     * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingPasswordPolicies.html"> Managing an IAM Password Policy </a>
     * .
     * </p>
     *
     * @param getAccountPasswordPolicyRequest Container for the necessary
     *           parameters to execute the GetAccountPasswordPolicy operation on
     *           AmazonIdentityManagement.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         GetAccountPasswordPolicy service method, as returned by
     *         AmazonIdentityManagement.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonIdentityManagement indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(
            final GetAccountPasswordPolicyRequest getAccountPasswordPolicyRequest,
            final AsyncHandler<GetAccountPasswordPolicyRequest, GetAccountPasswordPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAccountPasswordPolicyResult>() {
            public GetAccountPasswordPolicyResult call() throws Exception {
              GetAccountPasswordPolicyResult result;
                try {
                result = getAccountPasswordPolicy(getAccountPasswordPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(getAccountPasswordPolicyRequest, result);
                 return result;
        }
    });
    }
    
}
        