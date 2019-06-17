
/*
 * Created on 2019-06-17 ( Time 13:09:01 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package ci.gcorp.aajesepci.rest.fact;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.TransactionSystemException;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import ci.gcorp.aajesepci.utils.contract.IController;
import ci.gcorp.aajesepci.utils.contract.IBasicBusiness;
import ci.gcorp.aajesepci.utils.contract.Request;
import ci.gcorp.aajesepci.utils.contract.Response;
import ci.gcorp.aajesepci.utils.enums.FunctionalityEnum;
import ci.gcorp.aajesepci.utils.ExceptionUtils;
import ci.gcorp.aajesepci.utils.FunctionalError;
import ci.gcorp.aajesepci.utils.StatusCode;
import ci.gcorp.aajesepci.utils.StatusMessage;
import ci.gcorp.aajesepci.utils.Validate;
import ci.gcorp.aajesepci.business.fact.BusinessFactory;

@Log
@Component
public class ControllerFactory<DTO> implements IController<DTO> {
    @Autowired
    private BusinessFactory<DTO> businessFactory;
    @Autowired
    private FunctionalError      functionalError;
    @Autowired
    private ExceptionUtils       exceptionUtils;
    @Autowired
    private HttpServletRequest   requestBasic;

    @Override
    public Response<DTO> create(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum) {
        Response<DTO> response   = new Response<DTO>();
        String        languageID = (String) requestBasic.getAttribute("CURRENT_LANGUAGE_IDENTIFIER");
        Locale        locale     = new Locale(languageID, "");
        try {
            response = Validate.validateList(request, response, functionalError, locale);
            if (!response.isHasError()) {
                response = businessFactory.create(iBasicBusiness, request, functionalityEnum, locale);
            } else {
                log.info(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
                return response;
            }
            if (!response.isHasError()) {
                log.info(String.format("code: {} -  message: {}", StatusCode.SUCCESS, StatusMessage.SUCCESS));
            } else {
                log.info(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
            }
        } catch (CannotCreateTransactionException e) {
            exceptionUtils.CANNOT_CREATE_TRANSACTION_EXCEPTION(response, locale, e);
        } catch (TransactionSystemException e) {
            exceptionUtils.TRANSACTION_SYSTEM_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        }
        return response;
    }

    @Override
    public Response<DTO> update(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum) {
        Response<DTO> response   = new Response<DTO>();
        String        languageID = (String) requestBasic.getAttribute("CURRENT_LANGUAGE_IDENTIFIER");
        Locale        locale     = new Locale(languageID, "");
        try {
            response = Validate.validateList(request, response, functionalError, locale);
            if (!response.isHasError()) {
                response = businessFactory.update(iBasicBusiness, request, functionalityEnum, locale);
            } else {
                log.info(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
                return response;
            }
            if (!response.isHasError()) {
                log.info(String.format("code: {} -  message: {}", StatusCode.SUCCESS, StatusMessage.SUCCESS));
            } else {
                log.info(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
            }
        } catch (CannotCreateTransactionException e) {
            exceptionUtils.CANNOT_CREATE_TRANSACTION_EXCEPTION(response, locale, e);
        } catch (TransactionSystemException e) {
            exceptionUtils.TRANSACTION_SYSTEM_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        }
        return response;
    }

    @Override
    public Response<DTO> delete(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum) {
        Response<DTO> response   = new Response<DTO>();
        String        languageID = (String) requestBasic.getAttribute("CURRENT_LANGUAGE_IDENTIFIER");
        Locale        locale     = new Locale(languageID, "");
        try {
            response = Validate.validateList(request, response, functionalError, locale);
            if (!response.isHasError()) {
                response = businessFactory.delete(iBasicBusiness, request, functionalityEnum, locale);
            } else {
                log.info(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
                return response;
            }
            if (!response.isHasError()) {
                log.info(String.format("code: {} -  message: {}", StatusCode.SUCCESS, StatusMessage.SUCCESS));
            } else {
                log.info(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
            }
        } catch (CannotCreateTransactionException e) {
            exceptionUtils.CANNOT_CREATE_TRANSACTION_EXCEPTION(response, locale, e);
        } catch (TransactionSystemException e) {
            exceptionUtils.TRANSACTION_SYSTEM_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        }
        return response;
    }

    @Override
    public Response<DTO> getByCriteria(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum) {
        Response<DTO> response   = new Response<DTO>();
        String        languageID = (String) requestBasic.getAttribute("CURRENT_LANGUAGE_IDENTIFIER");
        Locale        locale     = new Locale(languageID, "");
        try {
            response = Validate.validateObject(request, response, functionalError, locale);
            if (!response.isHasError()) {
                response = businessFactory.getByCriteria(iBasicBusiness, request, functionalityEnum, locale);
            } else {
                log.info(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
                return response;
            }
            if (!response.isHasError()) {
                log.info(String.format("code: {} -  message: {}", StatusCode.SUCCESS, StatusMessage.SUCCESS));
            } else {
                log.info(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
            }
        } catch (CannotCreateTransactionException e) {
            exceptionUtils.CANNOT_CREATE_TRANSACTION_EXCEPTION(response, locale, e);
        } catch (TransactionSystemException e) {
            exceptionUtils.TRANSACTION_SYSTEM_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        }
        return response;
    }
}
