package net.simpletimer.fanbox_supporter_api.date.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import net.simpletimer.fanbox_supporter_api.date.FanboxDate

/**
 * [FanboxDate]のSerializer
 * [FanboxDate.FormatType.FULL]を使用する
 *
 */
class FanboxDateFullSerializer : KSerializer<FanboxDate> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("FanboxDateFull", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: FanboxDate) {
        encoder.encodeString(value.convertTo(FanboxDate.FormatType.FULL))
    }

    override fun deserialize(decoder: Decoder): FanboxDate {
        val text = decoder.decodeString()
        return FanboxDate(FanboxDate.FormatType.FULL, text)
    }
}