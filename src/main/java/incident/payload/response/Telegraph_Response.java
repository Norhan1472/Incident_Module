package incident.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import incident.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Telegraph_Response {

        private long tghId;
        private long genId;
        private String tghCode;
        @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
        private Date tghDate;
        @JsonProperty("tghPostOffice")
        private String tgh_post_office;// office name,
        @JsonProperty("tghTemplateType")
        private String tgh_template_type;// temp type name,
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        private Date actRecDate;// act_rec-date,
        private String originOffice;// origin office
        private String senderAddress;
        private String message;
        private String callerName;
        private String callerTelNo;
        private String userCode;
        private long decoration;
        private String notes;
        private long urgent;
        private long admin;
        private long template;
        private long international;
        private long deliveryNotice;
        private String billTelNo;
        private String senderName;
        private String recipientName;
        @JsonFormat(pattern="dd-MM-yyyy HH:mm")
        private Date callDate;
        @JsonFormat(pattern="dd-MM-yyyy HH:mm")
        private Date sendDate;
        private String address;
        private long recipientVIP;
        private long tghCost;
        private String actualRecName;
        @JsonProperty("tghLanguage")
        private String tgh_language;//language name
        @JsonProperty("tghCountry")
        private String tgh_country;// country name
        @JsonProperty("tghMsgStatus")
        private String tgh_msg_status;//statusName
        private long seqNo; // request,
        private String personName;
        private String personTitle;
        private Integer supportArchive;

}
