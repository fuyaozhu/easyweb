package com.wf.ew.common.constants;

public enum DiseaseNameEnum {

    BACTERIAL_DYSENTERY("细菌性痢疾","bacterial_dysentery"),
    TYPHOON_AND_PARATYPHOID_FEVER("伤寒和副伤寒	","typhoon_and_paratyphoid_fever"),
    VIRAL_HEPATITIS("病毒性肝炎	","viral_hepatitis"),
    ACTIVE_PULMONARY_TUBERCULOSIS("活动性肺结核","active_pulmonary_tuberculosis"),
    PURULENT_OR_EXUDATIVE_SKIN_DISEASES("化脓性或渗出性皮肤病","purulent_or_exudative_skin_diseases"),
    FUNGAL_INFECTIOUS_DISEASES_OF_HAND("手部真菌感染性疾病","fungal_infectious_diseases_of_hand"),
    CHOLERA("霍乱","cholera"),
    AMOEBIC_DYSENTERY("阿米巴性痢疾","amoebic_dysentery"),
    HAND_ECZEMA("手部湿疹","hand_eczema"),
    PSORIASIS_OR_SCALES_ON_THE_HANDS("手部的银屑病或者鳞屑","psoriasis_or_scales_on_the_hands");



    private String name;
    private String code;


    DiseaseNameEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DiseaseNameEnum{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
