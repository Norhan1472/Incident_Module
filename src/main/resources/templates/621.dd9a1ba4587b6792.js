"use strict";(self.webpackChunkincident=self.webpackChunkincident||[]).push([[621],{7621:(ue,f,r)=>{r.r(f),r.d(f,{ArchiveModule:()=>pe});var m=r(7553),b=r(7023),G=r(7269),e=r(4946);const F=["1_code","1_recievedDate","1_recievedBy","1_tghId","1_incidentTypeCode","1_archivedBy"],B=[{header:"Code",name:"code",id:"code_incident_search",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Recieved By",name:"recievedBy",id:"recievedby_incident_search",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Telegraph ID",name:"telegraphId",id:"telegraph_id_incident_search",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Recieved Date",name:"recievedDate",id:"recieveddate_incident_search",defaultValue:"",required:!1,type:"date",status:"disabled"},{header:"Caller Name",name:"callerName",id:"caller_name_incident_search",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Archive Date",name:"archiveDate",id:"archive_date_incident_search",defaultValue:"",required:!1,type:"date",status:"disabled"},{header:"Caller Address",name:"callerAddress",id:"caller_address_incident_search",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Archived By",name:"archivedBy",id:"archived_by_incident_search",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Caller Tel No",name:"callerTelNo",id:"caller_tel_no_incident_search",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Incident Type Code",name:"incidentTypeCode",id:"incident_type_code_incident_search",defaultValue:"",required:!1,type:"dropdown",isDropDown:{label:"incidentTypeName",options:[],optionsName:"incidentTypeCode",value:"incidentTypeCode"},status:"disabled"},{header:"Tgh Date",name:"tghDate",id:"tgh_date_incident_search",defaultValue:"",required:!1,type:"date",status:"disabled"}],M=[{header:"Code",name:"code",id:"code_add",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Received Date",name:"receivedDate",id:"recieveddate_add",defaultValue:"",required:!1,type:"date",status:"disabled"},{header:"Received By",name:"receivedBy",id:"recievedby_add",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Telegraph ID",name:"tghId",id:"telegraph_id_add",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Query Flag",name:"queryFlag",id:"query_flag_add",defaultValue:"",required:!1,type:"checkbox",status:"disabled"},{header:"Caller Name",name:"callerName",id:"caller_name_add",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Caller Address",name:"callerAddress",id:"caller_address_add",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Caller City Code",name:"callerCityCode",id:"caller_city_code_add",defaultValue:"",required:!0,type:"text",status:"disabled"},{header:"Caller Tel No",name:"callerTelNo",id:"caller_tel_no_add",defaultValue:"",required:!0,type:"text",status:"disabled"},{header:"Incident Type Code",name:"incidentTypeCode",id:"incident_type_code_add",defaultValue:"",required:!1,type:"dropdown",isDropDown:{label:"incidentTypeName",options:[],optionsName:"incidentTypeName",value:"incidentTypeCode"},status:"disabled"},{header:"Status Code",name:"statusCode",id:"status_code",defaultValue:"",required:!1,type:"dropdown",isDropDown:{label:"statusName",options:[],optionsName:"statusName",value:"statusCode"},status:"disabled"},{header:"Incident Notes",name:"incidentNotes",id:"incident_notes_add",defaultValue:"",required:!1,type:"textarea",status:"disabled"},{header:"archivedBy",name:"archivedBy",id:"archivedBy_incident_search",defaultValue:"",required:!1,type:"text",status:"disabled"},{header:"Archive Date",name:"archiveDate",id:"archive_date",defaultValue:"",required:!1,type:"date",status:"disabled"}];var h=r(8268),J=r(8478),y=r(3155),C=r(9862),p=r(7417);let T=(()=>{class i{constructor(t,a){this.http=t,this.toast=a}get_archive_data(t,a=0,s=50){return this.http.post(y.D.apiURL+`/AR_INCIDENT/searchArIncident?pageNo=${a}&pageSize=${s}`,t)}get_tel_details(t,a){return this.http.get(y.D.apiURL+`/Telegraph/getTelegraphById?tghId=${t}`,{params:a})}}return i.\u0275fac=function(t){return new(t||i)(e.LFG(C.eN),e.LFG(p.k))},i.\u0275prov=e.Yz7({token:i,factory:i.\u0275fac,providedIn:"root"}),i})();var A=r(7759),D=r(7057),S=r(8180),H=r(986),l=r(6814),I=r(8355);let O=(()=>{class i{constructor(t,a,s){this.sharedService=t,this.lkps=a,this.datePipe=s,this.search_event=new e.vpe}ngOnInit(){this.cols=this.sharedService.translate(B),this.form=this.sharedService.create_form_by_cols(this.cols),this.track_lkps(),this.lkps.get_lkp_type_code()}track_lkps(){this.lkps.lkp_incident_type_code.pipe((0,S.q)(1)).subscribe(t=>{this.cols.map(a=>{a.isDropDown&&"incidentTypeCode"==a.name&&(a.isDropDown.options=t)})})}search({value:t}){let s=this.sharedService.convertDatePropsToString(t);s.receivedDate=t.recievedDate,delete s.recievedDate,console.log("obj_search",s),s.tghId=this.form.controls.telegraphId.value,delete s.telegraphId,this.search_event.emit(s)}}return i.\u0275fac=function(t){return new(t||i)(e.Y36(h.F),e.Y36(H.z),e.Y36(l.uU))},i.\u0275cmp=e.Xpm({type:i,selectors:[["app-archive-search"]],outputs:{search_event:"search_event"},decls:1,vars:5,consts:[[3,"reset","action","form","nCols","cols","onSubmit"]],template:function(t,a){1&t&&(e.TgZ(0,"mts-form",0),e.NdJ("onSubmit",function(d){return a.search(d)}),e.qZA()),2&t&&e.Q6J("reset",!0)("action","search")("form",a.form)("nCols",3)("cols",a.cols)},dependencies:[I.U]}),i})(),Q=(()=>{class i{constructor(t,a,s,d,o){this.sharedService=t,this.softSave=a,this.router=s,this.ser=d,this.toast=o,this.cols=[],this.loading=!1,this.archiveDataHeaders=F,this.archiveData=[],this.totalRecords=0,this.pageNumber=0,this.pageSize=50}ngOnInit(){this.cols=this.sharedService.get_cols_by_fileds_and_headers(this.archiveDataHeaders)}archive_clicked(t){if("Paginate"==t.type)return this.pageNumber=t.value.page,this.pageSize=t.value.rows,void this.get_archive_data(this.objSearch);sessionStorage.setItem("archive_row",JSON.stringify(t)),this.id=t.value.code,this.setids(),this.router.navigate([`archive/manage/${this.id}`])}get_archive_data(t){this.objSearch=t;let a=this.sharedService.ignoreHiddenFields(this.cols,t.value);this.softSave.formSoftSave({cols:this.cols,value:a}),this.loading=!0,this.archiveData=[],this.ser.get_archive_data(t,this.pageNumber,this.pageSize).subscribe(s=>{this.totalRecords=s.body.totalSize,this.loading=!1,Array.isArray(s.body.result)&&(this.archiveData=s.body.result)},s=>{this.loading=!1},()=>{}),this.pageNumber=0,this.pageSize=50}setids(){this.softSave.setIdsInLS(this.archiveData,"code",this.id)}}return i.\u0275fac=function(t){return new(t||i)(e.Y36(h.F),e.Y36(J.a),e.Y36(m.F0),e.Y36(T),e.Y36(p.k))},i.\u0275cmp=e.Xpm({type:i,selectors:[["app-archive-table"]],decls:3,vars:6,consts:[["title","Archive"],[3,"search_event"],[3,"id","cols","data","show_edit","paginator","totalRecords","btn_click"]],template:function(t,a){1&t&&(e._UZ(0,"mts-header-breadcrumb",0),e.TgZ(1,"app-archive-search",1),e.NdJ("search_event",function(d){return a.get_archive_data(d)}),e.qZA(),e.TgZ(2,"mts-table",2),e.NdJ("btn_click",function(d){return a.archive_clicked(d)}),e.qZA()),2&t&&(e.xp6(2),e.Q6J("id","incidentTableID")("cols",a.cols)("data",a.archiveData)("show_edit",!0)("paginator",!0)("totalRecords",a.totalRecords))},dependencies:[A.a,D.S,O]}),i})(),R=(()=>{class i{}return i.\u0275fac=function(t){return new(t||i)},i.\u0275cmp=e.Xpm({type:i,selectors:[["app-archive-home"]],decls:1,vars:0,template:function(t,a){1&t&&e._UZ(0,"app-archive-table")},dependencies:[Q]}),i})();var u=r(8690),U=r(7130),k=r(9726);const N=[["vipNo",0],["recipientVIP",0]],P=["1_senderName","1_billTelNo","1_notes"],z=["1_recipientTelNo","1_recipientName","1_address"],q=["genId","userCode","callDate","callerTelNo","callerName","billTelNo","sendDate","countryCode","langCode","planCode","template","tempTypeCode","tempCode","deliveryNotice","decoration","urgent","admin","international","notes","message"];var L=r(1426),w=r(11),X=r(5406),g=r(9627),V=r(6725),x=r(870),Y=r(1252),_=r(799);const $=["labels_comp"];let Z=(()=>{class i{constructor(t,a,s,d,o){this.apis=t,this.toast=a,this.sharedService=s,this.datePipe=d,this.translate=o,this.generator_data=void 0,this.headers=q,this.checkboxArray=N,this.checkBoxMap=new Map(this.checkboxArray),this.sender_headers=P,this.recipient_headers=z,this.loading=!1,this.lang="ar",this.header="Senders",this.header2="Receipents",this.rec=[],this.sen=[],this.lang=this.translate.get_app_lang(),this.setHeader(),this.show_lables()}setHeader(){"ar"==this.lang?(this.header="\u0627\u0644\u0645\u064f\u0631\u0633\u0650\u0644\u064a\u0646",this.header2="\u0627\u0644\u0645\u064f\u0631\u0633\u064e\u0644 \u0627\u0644\u064a\u0647\u0645"):(this.header="Senders",this.header2="Receipents")}get_generator(t){this.loading=!0,this.apis.get_generator_by_id(t).subscribe(a=>{this.generator_data=a.body,this.generator_data.callDate=this.datePipe.transform(this.generator_data.callDate,"dd-MM-yyyy HH:mm"),this.generator_data.sendDate=this.datePipe.transform(this.generator_data.sendDate,"dd-MM-yyyy HH:mm"),this.loading=!1,Array.isArray(a.body.senders)&&(this.sen=a.body.senders.slice()),Array.isArray(a.body.recepients)&&(this.rec=a.body.recepients.slice()),delete this.generator_data.senders,delete this.generator_data.recepients,setTimeout(()=>{this.labels_comp.set_labels(this.generator_data,this.checkBoxMap,"ginDetails")},100)},a=>{this.loading=!1},()=>{})}show_lables(){this.sender_cols=this.sharedService.get_cols_by_fileds_and_headers(this.sender_headers),this.recipient_cols=this.sharedService.get_cols_by_fileds_and_headers(this.recipient_headers)}}return i.\u0275fac=function(t){return new(t||i)(e.Y36(Y.b),e.Y36(p.k),e.Y36(h.F),e.Y36(l.uU),e.Y36(g.s))},i.\u0275cmp=e.Xpm({type:i,selectors:[["gen-id-details"]],viewQuery:function(t,a){if(1&t&&e.Gf($,5),2&t){let s;e.iGM(s=e.CRH())&&(a.labels_comp=s.first)}},decls:7,vars:9,consts:[["labels_comp",""],[3,"header"],[3,"id","cols","data","loading"],[3,"id","cols","data"]],template:function(t,a){1&t&&(e._UZ(0,"app-labels-form",null,0),e.TgZ(2,"p-tabView")(3,"p-tabPanel",1),e._UZ(4,"mts-table",2),e.qZA(),e.TgZ(5,"p-tabPanel",1),e._UZ(6,"mts-table",3),e.qZA()()),2&t&&(e.xp6(3),e.Q6J("header",a.header2),e.xp6(1),e.Q6J("id","receipentsTableID")("cols",a.recipient_cols)("data",a.rec)("loading",a.loading),e.xp6(1),e.Q6J("header",a.header),e.xp6(1),e.Q6J("id","sendersTableID")("cols",a.sender_cols)("data",a.sen))},dependencies:[A.a,x.x,_.xf,_.x4]}),i})();const E=["gen_id_details"],j=["generator_modal"],W=["labels_comp"];function K(i,n){1&i&&e.GkF(0)}function ee(i,n){1&i&&e._UZ(0,"gen-id-details",null,6)}let te=(()=>{class i{constructor(t,a,s,d,o,c){this.incidentService=t,this.archivedService=a,this.toast=s,this.sharedService=d,this.permissionsService=o,this.translate=c,this.tgh_code=0,this.data=[],this.loading=!1,this.lang="ar",this.checkboxArray=N,this.checkBoxMap=new Map(this.checkboxArray),this.headers=u.w,this.archiveGenPermission=!1,this.preCode="-1",this.lang=this.translate.get_app_lang(),[this.archiveGenPermission]=this.permissionsService.havePermissions(["TelegraphGenerator.view"])}ngOnInit(){this.incidentService.getTghId().pipe((0,L.b)(200)).subscribe(t=>{t!==this.tgh_code&&(this.tgh_code=t,this.get_AR_telegraphs_details(t))})}ngOnChanges(t){console.warn(t)}get_AR_telegraphs_details(t){if(console.log("aechived"),"-1"!==this.preCode)this.preCode=t;else if(this.preCode==t||""==t)return;this.loading=!0;const a=(new C.LE).set("loader","no");this.archivedService.get_tel_details(t,a).pipe((0,S.q)(1)).subscribe(s=>{this.data=s.body,this.genid=this.data.genId,this.loading=!1,this.labels_comp?.set_labels(this.data,this.checkBoxMap,"tghDetails")},s=>{this.loading=!1},()=>{})}get_gen_details(){this.gen_id_details?.get_generator(this.genid),this.generator_modal?.clickOnButton("open")}}return i.\u0275fac=function(t){return new(t||i)(e.Y36(w.k),e.Y36(T),e.Y36(p.k),e.Y36(h.F),e.Y36(X.q),e.Y36(g.s))},i.\u0275cmp=e.Xpm({type:i,selectors:[["app-archive-telegraph-details"]],viewQuery:function(t,a){if(1&t&&(e.Gf(E,5),e.Gf(j,5),e.Gf(W,5)),2&t){let s;e.iGM(s=e.CRH())&&(a.gen_id_details=s.first),e.iGM(s=e.CRH())&&(a.generator_modal=s.first),e.iGM(s=e.CRH())&&(a.labels_comp=s.first)}},inputs:{tgh_code:"tgh_code"},features:[e.TTD],decls:7,vars:4,consts:[[3,"get_gen"],["labels_comp",""],[3,"size","modal_name","header_name"],["generator_modal",""],[4,"ngTemplateOutlet"],["myComponent",""],["gen_id_details",""]],template:function(t,a){if(1&t&&(e.TgZ(0,"app-labels-form",0,1),e.NdJ("get_gen",function(){return a.archiveGenPermission&&a.get_gen_details()}),e.qZA(),e.TgZ(2,"mts-modal",2,3),e.YNc(4,K,1,0,"ng-container",4),e.qZA(),e.YNc(5,ee,2,0,"ng-template",null,5,e.W1O)),2&t){const s=e.MAs(6);e.xp6(2),e.Q6J("size","modal-xl")("modal_name","gen-id-telegraph")("header_name","ar"==a.lang?"\u0639\u0631\u0636 \u0627\u0644\u0628\u0631\u0642\u064a\u0629 \u0627\u0644\u0627\u0635\u0644\u064a\u0629":"View Gen Id Details"),e.xp6(2),e.Q6J("ngTemplateOutlet",s)}},dependencies:[l.tP,V.z,x.x,Z]}),i})();var ae=r(8404);const ie=["gen_id_details"],se=["generator_modal"];function re(i,n){if(1&i){const t=e.EpF();e.TgZ(0,"mts-paginator",8),e.NdJ("moveTo",function(s){e.CHM(t);const d=e.oxw();return e.KtG(d.ChangeTitle(s))}),e.qZA()}if(2&i){const t=e.oxw();e.Q6J("breadcrumb",t.breadcumb)}}function ne(i,n){1&i&&e._UZ(0,"mts-header-breadcrumb",9)}function de(i,n){1&i&&e.GkF(0)}function oe(i,n){1&i&&e._UZ(0,"gen-id-details",null,10)}let le=(()=>{class i{constructor(t,a,s,d,o,c,v){this.service=t,this.apis=a,this.toast=s,this.incidentService=d,this.translate=o,this.router=c,this.cdr=v,this.tgh_code=0,this.cols=[],this.data=[],this.loading=!1,this.checkboxArray=u.S,this.checkBoxMap=new Map(this.checkboxArray),this.headers=u.w,this.followUpData=[],this.followUpDataHeaders=U.F,this.incident_code=15,this.header_name="Archive Incident",this.lang="ar",this.incidentCode="",this.tabs=[],this.currentCode="",this.breadcumb={},this.id=c.url.split("/")[3],this.lang=this.translate.get_app_lang(),this.tabs=[{header:"ArchivedIncidentFollow",component:k.c},{header:"TelegraphDetails",component:te}]}ngAfterContentChecked(){this.cdr.detectChanges()}ngOnInit(){this.lang=this.translate.get_app_lang(),this.setBreadcrumb(),this.setColumns(),this.createForm(),this.table_cols=this.service.get_cols_by_fileds_and_headers(this.followUpDataHeaders),this.incidentService.setIncidentCode(this.id),this.get_row_details(this.id)}setBreadcrumb(t=this.id){let a=Object.assign({},this.breadcumb);a.titles=["viewArchive",`${t}`],a.url="/archive",this.breadcumb=Object.assign({},a),this.showTabs=!0}setColumns(){this.cols=this.service.translate(M)}moveTo(t){console.log(t)}createForm(){this.form=this.service.create_form_by_cols(this.cols),this.cols.map(t=>{"disabled"==t.status&&this.form.controls[t.name].disable()})}convertStringToObhect(t){let a=t.incidentTypeCode;console.log("value",t);let d=t.statusCode,o={statusCode:d,statusName:d};return this.cols[9].isDropDown.options=[{incidentTypeCode:a,incidentTypeName:a}],this.cols[10].isDropDown.options=[o],t}get_row_details(t){this.loading=!0,this.apis.get_row_details(t).subscribe(a=>{this.telId=a.body.tghId,this.incidentService.setTghId(this.telId);const d=a.body.archiveDate;a.body.receivedDate=this.convertStringToDate(a.body.receivedDate),a.body.archiveDate=this.convertStringToDate(d);let o=this.convertStringToObhect(a.body);this.form.patchValue(o),this.tghid=a.body.tghId,this.loading=!1,this.tghDetails()},a=>{this.loading=!1},()=>{})}tghDetails(){}get_gen_details(){this.gen_id_details?.get_generator(this.genid),this.generator_modal?.clickOnButton("open")}tabChanged(t){}convertStringToDate(t){const[a,s]=t.split(" "),[d,o,c]=a.split("-"),[v,me]=s.split(":");return new Date(parseInt(c),parseInt(o)-1,parseInt(d),parseInt(v),parseInt(me))}ChangeTitle(t){console.log(t),this.get_row_details(t),this.router.navigate([`/archive/manage/${t}`]),this.setBreadcrumb(t)}ngOnDestroy(){this.tabs=[]}}return i.\u0275fac=function(t){return new(t||i)(e.Y36(h.F),e.Y36(Y.b),e.Y36(p.k),e.Y36(w.k),e.Y36(g.s),e.Y36(m.F0),e.Y36(e.sBO))},i.\u0275cmp=e.Xpm({type:i,selectors:[["app-view-archive"]],viewQuery:function(t,a){if(1&t&&(e.Gf(ie,5),e.Gf(se,5)),2&t){let s;e.iGM(s=e.CRH())&&(a.gen_id_details=s.first),e.iGM(s=e.CRH())&&(a.generator_modal=s.first)}},inputs:{tgh_code:"tgh_code"},decls:12,vars:12,consts:[[3,"breadcrumb","moveTo",4,"ngIf","ngIfElse"],["el",""],[3,"form","form_width","action","nCols","cols"],[3,"tabs","tabChangedTo"],[3,"size","modal_name","header_name"],["generator_modal",""],[4,"ngTemplateOutlet"],["myComponent",""],[3,"breadcrumb","moveTo"],["title","Add Incident"],["gen_id_details",""]],template:function(t,a){if(1&t&&(e.YNc(0,re,1,1,"mts-paginator",0),e.YNc(1,ne,1,0,"ng-template",null,1,e.W1O),e._UZ(3,"mts-form",2),e.ynx(4),e.TgZ(5,"mts-tabs-view",3),e.NdJ("tabChangedTo",function(d){return a.tabChanged(d)}),e.qZA(),e.BQk(),e.TgZ(6,"mts-modal",4,5),e._uU(8,"\n> "),e.YNc(9,de,1,0,"ng-container",6),e.qZA(),e.YNc(10,oe,2,0,"ng-template",null,7,e.W1O)),2&t){const s=e.MAs(2),d=e.MAs(11);e.Q6J("ngIf",a.showTabs)("ngIfElse",s),e.xp6(3),e.Q6J("form",a.form)("form_width",100)("action","none")("nCols",2)("cols",a.cols),e.xp6(2),e.Q6J("tabs",a.tabs),e.xp6(1),e.Q6J("size","modal-xl")("modal_name","gen-id-telegraph")("header_name","ar"==a.lang?"\u0639\u0631\u0636 \u0627\u0644\u0628\u0631\u0642\u064a\u0629 \u0627\u0644\u0627\u0635\u0644\u064a\u0629":"View Gen Id Details"),e.xp6(3),e.Q6J("ngTemplateOutlet",d)}},dependencies:[l.O5,l.tP,I.U,V.z,D.S,ae.J,b.C,Z]}),i})();var ce=r(6812);const he=[{path:"",component:R},{path:"manage/:id",component:le}];let pe=(()=>{class i{}return i.\u0275fac=function(t){return new(t||i)},i.\u0275mod=e.oAB({type:i}),i.\u0275inj=e.cJS({providers:[l.uU],imports:[G.m,m.Bz.forChild(he),b.C,ce.t,_.LU]}),i})()}}]);