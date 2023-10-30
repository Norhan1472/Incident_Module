package incident.wrapper;

import incident.models.AR_INCIDENT;
import incident.models.TGH_COUNTRY_VIP;
import incident.models.TGH_TELEGRAPH;
import incident.payload.response.Telegraph_Response;

import java.util.Set;

public class AR_TELEGRAPH_DTO {
    public AR_INCIDENT mapTelegraphIntoResponse(AR_INCIDENT ar_incident,String statusName,String typeName){
        AR_INCIDENT response = new AR_INCIDENT();
        response.setCode(ar_incident.getCode());
        response.setTghId(ar_incident.getTghId());
        response.setCallerName(ar_incident.getCallerName());
        response.setCallerAddress(ar_incident.getCallerAddress());
        response.setCallerTelNo(ar_incident.getCallerTelNo());
        response.setCallerCityCode(ar_incident.getCallerCityCode());
        response.setQueryFlag(ar_incident.getQueryFlag());
        response.setIncidentNotes(ar_incident.getIncidentNotes());
        response.setReceivedBy(ar_incident.getReceivedBy());
        response.setReceivedDate(ar_incident.getReceivedDate());
        response.setArchiveDate(ar_incident.getArchiveDate());
        response.setArchivedBy(ar_incident.getArchivedBy());
        if(ar_incident.getIncidentTypeCode()!=null){
            response.setIncidentTypeCode(typeName);
        }
        if(ar_incident.getStatusCode()!=null)
            response.setStatusCode(statusName);

        return response;
    }
}
