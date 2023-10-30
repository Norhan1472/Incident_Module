package incident.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "TGH_GENERATOR")
public class TGH_GENERATOR {
    @Id
    @Column(name = "GEN_ID")
    private long genId;
    @Column(name = "USER_CODE")
    private String userCode;
    @Column(name = "CALL_DATE")
    private Date callDate;
    @Column(name = "CALLER_TEL_NO")
    private String callerTelNo;
    @Column(name = "CALLER_NAME")
    private String callerName;
    @Column(name = "BILL_TEL_NO")
    private String billTelNo;
    @Column(name = "SEND_DATE")
    private Date sendDate;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Column(name = "LANG_CODE")
    private String langCode;
    @Column(name = "PLAN_CODE")
    private String planCode;
    @Column(name = "TEMPLATE")
    private long template;
    @Column(name = "TEMP_TYPE_CODE")
    private String tempTypeCode;
    @Column(name = "TEMP_CODE")
    private String tempCode;
    @Column(name = "DELIVERY_NOTICE")
    private long deliveryNotice;
    @Column(name = "DECORATION")
    private long decoration;
    @Column(name = "URGENT")
    private long urgent;
    @Column(name = "ADMIN")
    private long admin;
    @Column(name = "INTERNATIONAL")
    private long international;
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "MESSAGE")
    @Lob
    private String message;
    @OneToMany(mappedBy = "tgh_generator",fetch = FetchType.EAGER)
    private Set<TGH_SENDER>senders = new HashSet<>();
    @OneToMany(mappedBy = "tgh_generator",fetch = FetchType.EAGER)
    private Set<TGH_RECEPIENT>recepients = new HashSet<>();
}
