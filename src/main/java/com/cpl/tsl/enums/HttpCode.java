package com.cpl.tsl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class HttpCode {
    /**
     * （成功）  服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页。 
     */
    public static final int SUCCESS = 200;
    /**
     * （已创建）  请求成功并且服务器创建了新的资源。 
     */
    public static final int BUILD_SUCCESS = 201;
    /**
     * （已接受）  服务器已接受请求，但尚未处理。
     */
    public static final int ACCEPTED_SUCCESS = 202;
    /**
     * （非授权信息）  服务器已成功处理了请求，但返回的信息可能来自另一来源。 
     */
    public static final int UNAUTHORIZED_INFORMATION_SUCCESS = 203;
    /**
     * （无内容）  服务器成功处理了请求，但没有返回任何内容。 
     */
    public static final int NO_CONTENT_SUCCESS = 204;
    /**
     * （重置内容） 服务器成功处理了请求，但没有返回任何内容。 
     */
    public static final int REPETITION_SUCCESS = 205;
    /**
     * （部分内容）  服务器成功处理了部分 GET 请求。
     */
    public static final int PART_SUCCESS = 206;

    /**
     * （多种选择） 针对请求，服务器可执行多种操作。 服务器可根据请求者 (user agent) 选择一项操作，或提供操作列表供请求者选择。
     */
    public static final int MULTIPLE_CHOICES_ERROR = 300;
    /**
     * （永久移动） 请求的网页已永久移动到新位置。 服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置。
     */
    public static final int MOVED_PERMANENTLY_ERROR = 301;
    /**
     * （临时移动） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。
     */
    public static final int MOVE_ERROR = 302;
    /**
     * （查看其他位置） 请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码。
     */
    public static final int PARAM_ERROR = 303;
    /**
     * （未修改） 自从上次请求后，请求的网页未修改过。 服务器返回此响应时，不会返回网页内容。
     */
    public static final int NO_REPAIR_ERROR = 304;
    /**
     * （使用代理） 请求者只能使用代理访问请求的网页。 如果服务器返回此响应，还表示请求者应使用代理。
     */
    public static final int AGENT_ERROR = 305;
    /**
     * (临时重定向）  服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。
     */
    public static final int REDIRECT_ERROR = 307;

    /**
     * （错误请求） 服务器不理解请求的语法。
     */
    public static final int BAD_REQUIRED_ERROR = 400;
    /**
     * （未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。 
     */
    public static final int UNAUTHORIZED_ERROR = 401;
    /**
     * （禁止） 服务器拒绝请求。
     */
    public static final int FORBIDDEN_ERROR = 403;
    /**
     * （未找到） 服务器找不到请求的网页。
     */
    public static final int NOT_FOUND_ERROR = 404;
    /**
     * （方法禁用） 禁用请求中指定的方法。 
     */
    public static final int DISABLE_ERROR = 405;
    /**
     * （不接受） 无法使用请求的内容特性响应请求的网页。 
     */
    public static final int REJECT_ERROR = 406;
    /**
     * （需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。
     */
    public static final int NEED_AGENCY_ERROR = 407;
    /**
     * （请求超时）  服务器等候请求时发生超时。
     */
    public static final int TIMEOUT_ERROR = 408;
    /**
     * （冲突）  服务器在完成请求时发生冲突。 服务器必须在响应中包含有关冲突的信息。 
     */
    public static final int CLASH_ERROR = 409;
    /**
     * （已删除）  如果请求的资源已永久删除，服务器就会返回此响应。 
     */
    public static final int REMOVE_ERROR = 410;
    /**
     * （需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。 
     */
    public static final int LENGTH_REQUIRE_ERROR = 411;
    /**
     * （未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。
     */
    public static final int CONDITION_ERROR = 412;
    /**
     * （请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。 
     */
    public static final int OVERLOAD_ERROR = 413;
    /**
     * （请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。 
     */
    public static final int LENGTH_ERROR = 414;
    /**
     * （不支持的媒体类型） 请求的格式不受请求页面的支持。 
     */
    public static final int UNSUPPORTED_ERROR = 415;
    /**
     * （请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。 
     */
    public static final int NOT_SATISFIABLE_ERROR = 416;
    /**
     * （未满足期望值） 服务器未满足"期望"请求标头字段的要求。
     */
    public static final int NO_EXPECTATIONS_ERROR = 417;

    /**
     * （服务器内部错误）  服务器遇到错误，无法完成请求。 
     */
    public static final int INTERNAL_SERVER_ERROR = 500;
    /**
     * （尚未实施） 服务器不具备完成请求的功能。 例如，服务器无法识别请求方法时可能会返回此代码。 
     */
    public static final int UNKNOWN_ERROR = 501;
    /**
     * （错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。 
     */
    public static final int BAD_GATEWAY_ERROR = 502;
    /**
     * （服务不可用） 服务器目前无法使用（由于超载或停机维护）。 通常，这只是暂时状态。 
     */
    public static final int NO_SERVER_ERROR = 503;
    /**
     * （网关超时）  服务器作为网关或代理，但是没有及时从上游服务器收到请求。 
     */
    public static final int GATEWAY_TIMEOUT_ERROR = 504;
    /**
     * （HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本。
     */
    public static final int HTTP_VERSION_ERROR = 505;
    /**
     * Swagger内部错误
     */
    public static final int SWAGGER_ERROR = 510;

}
