package incident.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Entity
@Table(name = "TGH_TELEGHRAPH_ARCHIVE")
public class TGH_TELEGRAPH_ARCHIVE {
    @Id
    @Column(name = "TGH_ID")
    private long tghId;
    @Column(name = "GEN_ID")
    private long genId;
    @Column(name = "TGH_CODE")
    private String tghCode;
    @Column(name = "TGH_DATE")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date tghDate;
    // person title,person name,
    @ManyToOne
    @JoinColumn(name = "OFFICE_CODE")
    private TGH_POST_OFFICE tgh_post_office;// office name,
    @ManyToOne
    @JoinColumn(name = "TEMP_TYPE_CODE")
    private TGH_TEMPLATE_TYPE tgh_template_type;// temp type name,
    @Column(name = "ACTUAL_REC_DATE")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date actRecDate;// act_rec-date,
    @Column(name = "ORIGIN_OFFICE")
    private String originOffice;// origin office,
    @Column(name = "SENDER_ADDRESS")    // sender address,
    private String senderAddress;
    @Column(name = "MESSAGE")// message,
    private String message;
    @Column(name = "CALLER_NAME")
    private String callerName;
    @Column(name = "CALLER_TEL_NO")
    private String callerTelNo;
    @Column(name = "USER_CODE")
    private String userCode;
    @Column(name = "DECORATION")
    private long decoration;
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "URGENT")
    private long urgent;
    @Column(name = "ADMIN")
    private long admin;
    @Column(name = "TEMPLATE")
    private long template;
    @Column(name = "INTERNATIONAL")
    private long international;
    @Column(name = "DELIVERY_NOTICE")
    private long deliveryNotice;
    @Column(name = "BILL_TEL_NO")
    private String billTelNo;
    @Column(name = "SENDER_NAME")
    private String senderName;
    @Column(name = "REC_NAME")
    private String recipientName;
    @Column(name = "CALL_DATE")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date callDate;
    @Column(name = "SEND_DATE")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date sendDate;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "REC_VIP")
    private long recipientVIP;
    @Column(name = "TGH_COST")
    private long tghCost;
    @Column(name = "ACTUAL_REC_NAME")
    private String actualRecName;
    @ManyToOne
    @JoinColumn(name = "LANG_CODE")
    private TGH_LANGUAGE tgh_language;//language name
    @ManyToOne
    @JoinColumn(name = "COUNTRY_CODE")
    private TGH_COUNTRY tgh_country;// country name
    @ManyToOne
    @JoinColumn(name = "STATUS_CODE")
    private TGH_MSG_STATUS tgh_msg_status;
    @Column(name = "SEQ_NO")
    private long seqNo; // request,
    @Column(name = "VIP_NO")
    private Integer vipNo;
}
