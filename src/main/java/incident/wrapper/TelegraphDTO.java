package incident.wrapper;

import incident.models.TGH_COUNTRY_VIP;
import incident.models.TGH_TELEGRAPH;
import incident.models.TGH_TELEGRAPH_ARCHIVE;
import incident.payload.response.Telegraph_Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

public class TelegraphDTO {
    public Telegraph_Response mapTelegraphIntoResponse(TGH_TELEGRAPH_ARCHIVE telegraph){
        Telegraph_Response response = new Telegraph_Response();
        response.setTghId(telegraph.getTghId());
        response.setGenId(telegraph.getGenId());
        response.setTghCode(telegraph.getTghCode());
        response.setTghDate(telegraph.getTghDate());
        if(telegraph.getTgh_template_type()!=null)
            response.setTgh_template_type(telegraph.getTgh_template_type().getTempTypeName());
        if(telegraph.getTgh_template_type()!=null)
            response.setTgh_template_type(telegraph.getTgh_template_type().getTempTypeName());
        response.setActRecDate(telegraph.getActRecDate());
        response.setOriginOffice(telegraph.getOriginOffice());
        response.setSenderAddress(telegraph.getSenderAddress());
        response.setMessage(telegraph.getMessage());
        response.setCallerName(telegraph.getCallerName());
        response.setCallerTelNo(telegraph.getCallerTelNo());
        response.setUserCode(telegraph.getUserCode());
        response.setDecoration(telegraph.getDecoration());
        response.setNotes(telegraph.getNotes());
        response.setUrgent(telegraph.getUrgent());
        response.setAdmin(telegraph.getAdmin());
        response.setTemplate(telegraph.getTemplate());
        response.setInternational(telegraph.getInternational());
        response.setDeliveryNotice(telegraph.getDeliveryNotice());
        response.setBillTelNo(telegraph.getBillTelNo());
        response.setSenderName(telegraph.getSenderName());
        response.setRecipientName(telegraph.getRecipientName());
        response.setCallDate(telegraph.getCallDate());
        response.setSendDate(telegraph.getSendDate());
        response.setAddress(telegraph.getAddress());
        response.setRecipientVIP(telegraph.getRecipientVIP());
        response.setTghCost(telegraph.getTghCost());
        response.setActRecDate(telegraph.getActRecDate());
        if(telegraph.getTgh_language()!=null)
            response.setTgh_language(telegraph.getTgh_language().getLanguageName());
        if(telegraph.getTgh_country()!=null)
            response.setTgh_country(telegraph.getTgh_country().getCountryName());
        if(telegraph.getTgh_msg_status()!=null)
            response.setTgh_msg_status(telegraph.getTgh_msg_status().getStatusName());
        response.setSeqNo(telegraph.getSeqNo());
        if(telegraph.getVipNo()!=null){
            if(telegraph.getVipNo()==1){
                Set<TGH_COUNTRY_VIP>vips = telegraph.getTgh_country().getCountryVips();
                for(TGH_COUNTRY_VIP vip:vips){
                    response.setPersonName(vip.getPersonName());
                    response.setPersonTitle(vip.getPersonTitle());
                }
            }
        }

        return response;
    }
}
